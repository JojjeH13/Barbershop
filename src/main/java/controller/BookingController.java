package controller;

import entity.Booking;
import org.springframework.web.bind.annotation.*;
import repository.BookingRepository;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingRepository repo;

    public BookingController(BookingRepository repo) {
        this.repo = repo;
    }
    @PostMapping
    public Booking create(@RequestBody Booking booking) {
        return repo.save(booking);
    }

    @GetMapping("/api/bookings")
    public List<Booking> getAll(){
        return repo.findAll();
    }
}
