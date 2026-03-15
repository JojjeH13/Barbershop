package com.example.barbershop.repository;

import com.example.barbershop.entity.Customer;
import com.example.barbershop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByName(String name);
}