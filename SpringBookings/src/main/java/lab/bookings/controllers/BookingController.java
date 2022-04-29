package lab.bookings.controllers;

import lab.bookings.models.Apartment;
import lab.bookings.models.Booking;
import lab.bookings.repositories.ApartmentRepository;
import lab.bookings.repositories.BookingRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping(BookingController.BOOKINGS)
public class BookingController {

    public static final String BOOKINGS = "bookings";

    private final BookingRepository bookingRepository;
    private final ApartmentRepository apartmentRepository;
    
    public BookingController(BookingRepository bookingRepository,
                             ApartmentRepository apartmentRepository) {
        this.bookingRepository = bookingRepository;
        this.apartmentRepository = apartmentRepository;
    }
    
    @GetMapping
    public String getAll(Model model) {
        model.addAttribute(new Booking());
        model.addAttribute(BOOKINGS, bookingRepository.findAll());
        return BOOKINGS;
    }
    
    @PostMapping
    public String create(@Valid Booking booking, Errors errors,
                         Model model) {
        if (errors.hasErrors()) {
            model.addAttribute(BOOKINGS, bookingRepository.findAll());
            return BOOKINGS;
        }
        int numGuests = booking.getNumGuests();
        LocalDate startDay = booking.getFromDate();
        LocalDate endDay = booking.getToDate();
        List<Apartment> availableApartments = apartmentRepository.getFreeApartments(numGuests, startDay, endDay);
        if (!availableApartments.isEmpty()) {
            booking.setApartment(availableApartments.get(0));
            bookingRepository.save(booking);
            return "redirect:/" + BOOKINGS;
        }
        model.addAttribute("noApartmentAvailable", true);
        model.addAttribute(BOOKINGS, bookingRepository.findAll());
        return BOOKINGS;
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        bookingRepository.deleteById(id);
        return "redirect:/" + BOOKINGS;
    }
}

