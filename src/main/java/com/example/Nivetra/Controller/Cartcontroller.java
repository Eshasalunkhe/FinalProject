package com.example.Nivetra.Controller;

import com.example.Nivetra.Model.CartItem;
import com.example.Nivetra.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")

public class Cartcontroller {

    @Autowired
    private CartService cartService;

    @GetMapping
    public List<CartItem> viewCart() {
        return cartService.getCartItems();
    }

    @PostMapping("/add")
    public CartItem addToCart(@RequestParam Long productId, @RequestParam int quantity) {
        return cartService.addToCart(productId, quantity);
    }

    @DeleteMapping("/{id}")
    public String removeFromCart(@PathVariable Long id) {
        return cartService.removeFromCart(id);
    }
    
}
