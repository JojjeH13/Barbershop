package com.example.barbershop.service;

import com.example.barbershop.entity.Booking;
import com.example.barbershop.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService {
    private final BookingRepository repository;

    public BookingService(BookingRepository repository) {
        this.repository = repository;
    }

    public Booking createBooking(Booking booking) {
        List<String> stringList = new ArrayList<>();
        stringList.add("Hello World");
        List<Integer> integerList = new ArrayList<>();
        integerList.add(11);
        return repository.save(booking);
    }

    public List<Booking> getBookings() {
        return repository.findAll();
    }
}
