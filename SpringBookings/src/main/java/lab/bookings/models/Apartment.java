package lab.bookings.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import java.util.List;

@Entity
@Setter
@Getter
public class Apartment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;
    
    @Min(value = 1, message = "Value must be a positive integer")
    private int capacity;
    
    @OneToMany(mappedBy = "apartment")
    private List<Booking> bookings;
}
