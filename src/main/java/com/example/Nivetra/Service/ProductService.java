package com.example.Nivetra.Service;

import com.example.Nivetra.Model.Product;
import com.example.Nivetra.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepo;

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Product getProductById(Long id) {
        return productRepo.findById(id).orElse(null);
    }

    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    public Product updateProduct(Long id, Product updatedProduct) {
        if (productRepo.existsById(id)) {
            updatedProduct.setId(id);
            return productRepo.save(updatedProduct);
        }
        return null;
    }

    public String deleteProduct(Long id) {
        if (productRepo.existsById(id)) {
            productRepo.deleteById(id);
            return "Product deleted.";
        }
        return "Product not found.";
    }
}
