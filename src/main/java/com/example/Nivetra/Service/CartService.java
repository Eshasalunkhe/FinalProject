package com.example.Nivetra.Service;

import com.example.Nivetra.Model.CartItem;
import com.example.Nivetra.Model.Product;
import com.example.Nivetra.Repository.CartRepository;
import com.example.Nivetra.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepo;

    @Autowired
    private ProductRepository productRepo;

    public List<CartItem> getCartItems() {
        return cartRepo.findAll();
    }

    public CartItem addToCart(Long productId, int quantity) {
        Product product = productRepo.findById(productId).orElse(null);
        if (product != null) {
            CartItem cartItem = new CartItem(product, quantity);
            return cartRepo.save(cartItem);
        }
        return null;
    }

    public String removeFromCart(Long id) {
        if (cartRepo.existsById(id)) {
            cartRepo.deleteById(id);
            return "Item removed from cart.";
        }
        return "Item not found in cart.";
    }
}
