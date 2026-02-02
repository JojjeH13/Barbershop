package controller;

import entity.Booking;
import org.springframework.web.bind.annotation.*;
import repository.BookingRepository;
import service.BookingService;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService service;

    public BookingController(BookingService service) {
        this.service = service;
    }

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        return service.createBooking(booking);
    }

    @GetMapping
    public List<Booking> getBookings(){
        return service.getBookings();
    }
}
