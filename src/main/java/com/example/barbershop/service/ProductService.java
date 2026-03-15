package com.example.barbershop.service;

import com.example.barbershop.entity.Product;
import com.example.barbershop.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product createProduct(Product product) {
        return repository.save(product);
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product getProductById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Produkt med id " + id + " finns inte"));
    }

    /*public Product updateProduct(Long id, Product updatedProduct) {

        Product existingProduct = getProductById(id);

        existingProduct.setName(updatedProduct.getName());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setDuration(updatedProduct.getDuration());

        return repository.save(existingProduct);
    }

    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }*/

}
