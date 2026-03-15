package com.example.barbershop.repository;

import com.example.barbershop.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findByName(String employeeName);
}