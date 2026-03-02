package com.example.barbershop.service;

import com.example.barbershop.entity.Customer;
import com.example.barbershop.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {

        this.repository = repository;
    }

    public Customer createCustomer(Customer customer) {
        return repository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Kund med id " + id + " finns inte"));
    }

    public Customer updateCustomer(Long id, Customer updatedCustomer) {

        Customer existingCustomer = getCustomerById(id);

        existingCustomer.setName(updatedCustomer.getName());
        existingCustomer.setMail(updatedCustomer.getMail());
        existingCustomer.setPhone(updatedCustomer.getPhone());

        return repository.save(existingCustomer);
    }

    public void deleteCustomer(Long id) {
        repository.deleteById(id);
    }
}
