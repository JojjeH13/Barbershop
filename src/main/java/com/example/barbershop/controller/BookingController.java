package com.example.barbershop.controller;

import com.example.barbershop.entity.Booking;
import org.springframework.web.bind.annotation.*;
import com.example.barbershop.service.BookingService;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }
    @GetMapping("/health")
    public String health() {
        return "ok";
    }
    @PostMapping
    public Booking create(@RequestBody Booking booking) {
       return bookingService.createBooking(booking);
    }


    @GetMapping
    public List<Booking> getAll(){
       return bookingService.getBookings();
    }
}
