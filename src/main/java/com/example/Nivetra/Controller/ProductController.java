package com.example.Nivetra.Controller;

import com.example.Nivetra.Model.Product;
import com.example.Nivetra.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
<<<<<<< HEAD
@RequestMapping("/products")

=======
@RequestMapping("/api/products")
@CrossOrigin(origins = "*") // Allow frontend access
>>>>>>> decb205 (added updated files)
public class ProductController {

    @Autowired
    private ProductService productService;

<<<<<<< HEAD
    @GetMapping
    public List<Product> getAll() {
=======
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @GetMapping
    public List<Product> getAllProducts() {
>>>>>>> decb205 (added updated files)
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
<<<<<<< HEAD
    public Product getById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public Product add(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @PutMapping("/products/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product updatedProduct) {
        return productService.updateProduct(id, updatedProduct);
    }

    @DeleteMapping("/products/{id}")
    public String delete(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }
}
=======
    public Product getProductById(@PathVariable Long id) {
        return productService.getProduct(id);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        return productService.updateProduct(id, updatedProduct);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}

>>>>>>> decb205 (added updated files)
