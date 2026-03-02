package com.example.barbershop.repository;

import com.example.barbershop.entity.Booking;
import com.example.barbershop.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByBookingDateAndStatusNot(LocalDate date, Status status);
}