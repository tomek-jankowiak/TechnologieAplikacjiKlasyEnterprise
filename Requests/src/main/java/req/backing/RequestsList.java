package req.backing;

import java.time.LocalDate;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.inject.Inject;
import javax.validation.constraints.Size;
import req.entites.Request;
import req.facade.RequestFacadeLocal;

/**
 *
 * @author Tomek
 */
@Named(value = "requestsList")
@RequestScoped
public class RequestsList {

    @Inject
    private RequestFacadeLocal requestFacadeLocal;

    @Size( min = 3, max = 50, message = "{request.size}")
    private String newRequest;
    private HtmlDataTable requestsDataTable;

    public RequestsList() {
    }

    public String getNewRequest() {
        return newRequest;
    }

    public void setNewRequest(String newRequest) {
        this.newRequest = newRequest;
    }

    public HtmlDataTable getRequestsDataTable() {
        return requestsDataTable;
    }

    public void setRequestsDataTable(HtmlDataTable requestsDataTable) {
        this.requestsDataTable = requestsDataTable;
    }

    public List<Request> getAllRequests() {
        return requestFacadeLocal.findAll();
    }

    public String addRequest() {
        Request request = new Request();
        request.setRequestText(newRequest);
        request.setRequestDate(LocalDate.now());
        requestFacadeLocal.create(request);
        setNewRequest("");
        return null;
    }

    public String deleteRequest() {
        Request request = (Request) getRequestsDataTable().getRowData();
        requestFacadeLocal.remove(request);
        return null;
    }

    
}
