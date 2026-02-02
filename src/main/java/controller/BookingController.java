package controller;

import entity.Booking;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import repository.BookingRepository;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingRepository repo;

    public BookingController(BookingRepository repo) {

    }
    @PostMapping
    public Booking create(@RequestBody Booking booking) {
        return repo.save(booking);
    }
}
