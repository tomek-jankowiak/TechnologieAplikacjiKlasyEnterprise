package lab.bookings.controllers;

import lab.bookings.models.Apartment;
import lab.bookings.repositories.ApartmentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
@RequestMapping(ApartmentController.APARTMENTS)
public class ApartmentController {
    
    public static final String APARTMENTS = "apartments";

    private final ApartmentRepository apartmentRepository;
    
    public ApartmentController(ApartmentRepository apartmentRepository) {
        this.apartmentRepository = apartmentRepository;
    }
    
    @GetMapping
    public String getAll(Model model) {
        model.addAttribute(new Apartment());
        model.addAttribute(APARTMENTS, apartmentRepository.findAll());
        return APARTMENTS;
    }

    @PostMapping
    public String createTable(@Valid Apartment apartment, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute(APARTMENTS, apartmentRepository.findAll());
            return APARTMENTS;
        }
        apartmentRepository.save(apartment);
        return "redirect:/" + APARTMENTS;
    }
}
