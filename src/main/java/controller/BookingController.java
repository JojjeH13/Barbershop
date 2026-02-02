package controller;

import entity.Booking;
import org.springframework.web.bind.annotation.*;
import repository.BookingRepository;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingRepository repo;

    public BookingController(BookingRepository repo, BookingRepository repo1) {

        this.repo = repo;
    }
    @PostMapping
    public Booking create(@RequestBody Booking booking) {
        return repo.save(booking);
    }

    @GetMapping
    public List<Booking> getAll(){
        return repo.findAll();
    }
}
