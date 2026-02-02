package service;

import entity.Booking;
import repository.BookingRepository;

import java.util.ArrayList;
import java.util.List;

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
