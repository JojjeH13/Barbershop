package com.example.barbershop.dto;

public class BookingDTO {
    String employeeName;
    String productName;
    String customerName;

    public BookingDTO(String employeeName, String productName, String customerName) {
        this.customerName = customerName;
        this.productName = productName;
        this.employeeName = employeeName;
    }

    public BookingDTO() {
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
