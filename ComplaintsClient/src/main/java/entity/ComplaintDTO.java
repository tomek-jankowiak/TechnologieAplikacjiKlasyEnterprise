package entity;

import java.io.Serializable;
import java.time.LocalDate;

public class ComplaintDTO implements Serializable {

    private Long id;
    private LocalDate complaintDate;
    private String complaintText;
    private String author;
    private String status;

    public ComplaintDTO() {}
    
    private ComplaintDTO(Builder builder){
        id = builder.id;
        complaintDate = builder.complaintDate;
        complaintText = builder.complaintText;
        author = builder.author;
        status = builder.status;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getComplaintDate() {
        return complaintDate;
    }

    public void setComplaintDate(LocalDate complaintDate) {
        this.complaintDate = complaintDate;
    }

    public String getComplaintText() {
        return complaintText;
    }

    public void setComplaintText(String complaintText) {
        this.complaintText = complaintText;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ComplaintDTO{" + "id=" + id + 
                ", complaintDate=" + complaintDate + 
                ", complaintText=" + complaintText + 
                ", author=" + author + 
                ", status=" + status + 
                '}';
    }

    
    public static class Builder {

        private Long id;
        private LocalDate complaintDate;
        private String complaintText;
        private String author;
        private String status;
        
        public Builder id(Long id) {
            this.id = id;
            return this;
        }
    
        public Builder complaintDate(LocalDate complaintDate) {
            this.complaintDate = complaintDate;
            return this;
        }
        
        public Builder complaintText(String complaintText) {
            this.complaintText = complaintText;
            return this;
        }
        
        public Builder author(String author) {
            this.author = author;
            return this;
        }
        
        public Builder status(String status) {
            this.status = status;
            return this;
        }
        
        public ComplaintDTO build() {
            return new ComplaintDTO(this);
        }
    }
}
