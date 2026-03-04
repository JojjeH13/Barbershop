package com.example.barbershop.controller;

import com.example.barbershop.entity.Customer;
import com.example.barbershop.entity.Product;
import com.example.barbershop.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllCustomers() {
        return productService.getAllProducts();
    }

}
