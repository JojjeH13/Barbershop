package com.example.barbershop.dto;

import com.example.barbershop.entity.Employee;
import com.example.barbershop.entity.Product;

import java.time.LocalDate;
import java.time.LocalTime;

public class BookingDTO {
    String employeeName;
    String productName;
    String customerName;
    LocalDate bookingDate;
    LocalTime bookingTime;
    String customerMail;
    int customerPhone;
    int price;

    public BookingDTO(String employeeName, String productName, String customerName, LocalDate bookingDate, LocalTime bookingTime, String customerMail, int customerPhone, int price) {
        this.customerName = customerName;
        this.productName = productName;
        this.employeeName = employeeName;
        this.customerPhone = customerPhone;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
        this.price = price;
        this.customerMail = customerMail;
    }


    public String getEmployeeName() {
        return employeeName;
    }

    public String getProductName() {
        return productName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public LocalTime getBookingTime() {
        return bookingTime;
    }

    public String getCustomerMail() {
        return customerMail;
    }

    public int getCustomerPhone() {
        return customerPhone;
    }

    public int getPrice() {
        return price;
    }
}