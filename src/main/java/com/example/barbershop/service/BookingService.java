package com.example.barbershop.service;

import com.example.barbershop.entity.Booking;
import com.example.barbershop.repository.BookingRepository;
import org.springframework.stereotype.Service;
import com.example.barbershop.enums.Status;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService {
    private final BookingRepository repository;

    public BookingService(BookingRepository repository) {
        this.repository = repository;
    }

    public Booking createBooking(Booking booking) {
        return repository.save(booking);
    }



    public List<Booking> getBookings() {
        return repository.findAll();
    }

    public Booking getBookingById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bookning med id: " + id + " finns inte. "));
    }

    public Booking cancelBooking(Long id) {
        Booking booking = getBookingById(id);
        booking.setStatus(Status.AVBOKAD);
        return repository.save(booking);
    }

    public Booking completeBooking(Long id) {
        Booking booking = getBookingById(id);
        booking.setStatus(Status.KLAR);

        if (booking.getStatus() == Status.KLAR) {
            throw new RuntimeException("Kan inte avboka en redan klar bokning");
        }

        return repository.save(booking);
    }

    public List<LocalTime> findAvailableSlots(LocalDate date) {

        List<Booking> bookingsForDay =
                repository.findByBookingDateAndStatusNot(date, Status.AVBOKAD);

        List<LocalTime> availableSlots = new ArrayList<>();

        for (int hour = 10; hour < 19; hour++) {
            LocalTime time = LocalTime.of(hour, 0);

            boolean isBooked = bookingsForDay.stream()
                    .anyMatch(b -> b.getBookingTime().equals(time));

            if (!isBooked) {
                availableSlots.add(time);
            }
        }
        return availableSlots;
    }
}
