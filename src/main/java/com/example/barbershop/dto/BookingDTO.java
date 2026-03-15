package com.example.barbershop.dto;

import java.time.LocalDate;
import java.time.LocalTime;


public class BookingDTO {

    public BookingDTO() {}

    String employeeName;
    String productName;
    String customerName;
    LocalDate bookingDate;
    LocalTime bookingTime;
    String customerMail;
    int customerPhone;
    int price;

    public BookingDTO(String employeeName, String productName, String customerName,
                      LocalDate bookingDate, LocalTime bookingTime,
                      String customerMail, int customerPhone, int price) {

        this.employeeName = employeeName;
        this.productName = productName;
        this.customerName = customerName;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
        this.customerMail = customerMail;
        this.customerPhone = customerPhone;
        this.price = price;
    }

    public String getEmployeeName() { return employeeName; }
    public String getProductName() { return productName; }
    public String getCustomerName() { return customerName; }
    public LocalDate getBookingDate() { return bookingDate; }
    public LocalTime getBookingTime() { return bookingTime; }
    public String getCustomerMail() { return customerMail; }
    public int getCustomerPhone() { return customerPhone; }
    public int getPrice() { return price; }
}
