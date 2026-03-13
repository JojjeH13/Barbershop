package com.example.barbershop.service;

import com.example.barbershop.dto.BookingDTO;
import com.example.barbershop.entity.Booking;
import com.example.barbershop.entity.Customer;
import com.example.barbershop.entity.Product;
import com.example.barbershop.repository.BookingRepository;
import org.springframework.stereotype.Service;
import com.example.barbershop.enums.Status;

import java.util.List;

@Service
public class BookingService {
    private final BookingRepository repository;

    public BookingService(BookingRepository repository) {
        this.repository = repository;
    }

    public Booking createBooking(BookingDTO bookingdto) {

        Booking booking = new Booking();
        Customer customer = new Customer();

        customer.setCustomerName(bookingdto.getCustomerName());
        customer.setCustomerMail(bookingdto.getCustomerMail());
        customer.setCustomerPhone(bookingdto.getCustomerPhone());

        booking.setEmployee(bookingdto.getEmployeeName());
        booking.setProduct(bookingdto.getProductName());
        booking.setBookingDate(bookingdto.getBookingDate());
        booking.setBookingTime(bookingdto.getBookingTime());
        booking.setPrice(bookingdto.getPrice());

        booking.setCustomer(customer);

        return repository.save(booking);
    }


    public List<Booking> getBookings() {
        return repository.findAll();
    }

    public Booking getBookingById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bookning med id: " + id + " finns inte. "));
    }

    public BookingDTO getBookingDTOById(Long id) {
        Booking booking = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bookning med id: " + id + " finns inte. "));

        return new BookingDTO(
                booking.getEmployee().getName(),
                booking.getProduct().getName(),
                booking.getCustomer().getName(),
                booking.getBookingDate(),
                booking.getBookingTime(),
                booking.getCustomer().getCustomerMail(),
                booking.getCustomer().getCustomerPhone(),
                booking.getPrice()
        );
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
            throw new RuntimeException("Kan inte ändra en redan klar bokning");
        }

        booking.setStatus(Status.KLAR);

        return repository.save(booking);
    }


}
