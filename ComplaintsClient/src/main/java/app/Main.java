package app;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import entity.ComplaintDTO;
import java.util.List;
import java.util.Optional;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

public class Main {

    private static final String TARGET = "http://localhost:8080";
    private static final String COMPLAINTS_RESOURCE = "Complaints/resources/complaints";

    private final Client client;
    
    public Main(Client client) {
        this.client = client;
    }

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        Client client = ClientBuilder.newClient()
                .register(new JacksonJaxbJsonProvider(objectMapper, JacksonJaxbJsonProvider.DEFAULT_ANNOTATIONS));
        
        Main main = new Main(client);
        main.printCount();
        List<ComplaintDTO> complaints = main.printAndGetAll();
        Optional<ComplaintDTO> opened = main.findAnyOpen(complaints)
                .map(complaint -> main.printAndGetOne(complaint.getId()));
        opened.ifPresent(main::closeComplaint);
        main.printAllOpened();
        
        client.close();
    }
    
    private void printCount() {
        String count = client.target(TARGET)
                .path(COMPLAINTS_RESOURCE + "/count")
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);
        System.out.println("Count: " + count);
    }
    
    private List<ComplaintDTO> printAndGetAll() {
        List<ComplaintDTO> complaints = client.target(TARGET)
                .path(COMPLAINTS_RESOURCE)
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<ComplaintDTO>>(){});
        System.out.println("All complaints: ");
        complaints.forEach(System.out::println);
        return complaints;
    }
    
    private Optional<ComplaintDTO> findAnyOpen(List<ComplaintDTO> complaints) {
        return complaints.stream()
                .filter(complaint -> "open".equals(complaint.getStatus()))
                .findFirst();
    }
    
    private ComplaintDTO printAndGetOne(Long id) {
        ComplaintDTO complaint = client.target(TARGET)
                .path(COMPLAINTS_RESOURCE + "/" + id)
                .request(MediaType.APPLICATION_JSON)
                .get(ComplaintDTO.class);
        System.out.println("Opened complaint: " + complaint);
        return complaint;
    }
    
    private void closeComplaint(ComplaintDTO complaint) {
        complaint.setStatus("closed");
        System.out.println("Closing complaint " + complaint.getId());
        client.target(TARGET)
                .path(COMPLAINTS_RESOURCE + "/" + complaint.getId())
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.json(complaint));
    }
    
    private void printAllOpened() {
        List<ComplaintDTO> complaints = client.target(TARGET)
                .path(COMPLAINTS_RESOURCE)
                .queryParam("status", "open")
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<ComplaintDTO>>(){});
        System.out.println("All opened complaints: ");
        complaints.forEach(System.out::println);
    }
}
