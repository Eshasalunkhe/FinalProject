package com.example.Nivetra.Model;

import jakarta.persistence.*;
<<<<<<< HEAD

@Entity
public class CartItem {

=======
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {
>>>>>>> decb205 (added updated files)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
<<<<<<< HEAD
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    private int quantity;

    public CartItem() {}

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    // Getters and setters
    // ...
=======
    
    private Product product;

    @ManyToOne
    private User user;

    private int quantity;
>>>>>>> decb205 (added updated files)
}
