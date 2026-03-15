package com.example.barbershop.service;

import com.example.barbershop.dto.BookingDTO;
import com.example.barbershop.entity.Booking;
import com.example.barbershop.entity.Customer;
import com.example.barbershop.entity.Employee;
import com.example.barbershop.entity.Product;
import com.example.barbershop.repository.BookingRepository;
import com.example.barbershop.repository.ProductRepository;
import com.example.barbershop.repository.EmployeeRepository;
import com.example.barbershop.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    private final BookingRepository repository;
    private final EmployeeRepository employeeRepository;
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;

    public BookingService(
            BookingRepository repository,
            EmployeeRepository employeeRepository,
            CustomerRepository customerRepository,
            ProductRepository productRepository) {

        this.repository = repository;
        this.employeeRepository = employeeRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    public Booking createBooking(BookingDTO bookingdto) {

        Booking booking = new Booking();

        Customer customer = new Customer();
        customer.setName(bookingdto.getCustomerName());
        customer.setMail(bookingdto.getCustomerMail());
        customer.setPhone(bookingdto.getCustomerPhone());

        customerRepository.save(customer);

        Employee employee = employeeRepository
                .findByName(bookingdto.getEmployeeName());

        Product product = productRepository
                .findByName(bookingdto.getProductName());

        booking.setBookingDate(bookingdto.getBookingDate());
        booking.setBookingTime(bookingdto.getBookingTime());
        booking.setPrice(bookingdto.getPrice());

        booking.setCustomer(customer);
        booking.setEmployee(employee);
        booking.setProduct(product);

        return repository.save(booking);
    }

    public List<Booking> getBookings() {
        return repository.findAll();
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
                booking.getCustomer().getMail(),
                booking.getCustomer().getPhone(),
                booking.getPrice()
        );
    }

    /*public Booking cancelBooking(Long id) {
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
    }*/


}

