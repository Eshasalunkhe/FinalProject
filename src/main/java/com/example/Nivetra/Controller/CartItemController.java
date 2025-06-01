package com.example.Nivetra.Controller;

import com.example.Nivetra.Model.CartItem;
import com.example.Nivetra.Service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "*")
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    @PostMapping
    public CartItem addToCart(@RequestBody CartItem item) {
        return cartItemService.addToCart(item);
    }

    @GetMapping("/user/{userId}")
    public List<CartItem> getCartItems(@PathVariable Long userId) {
        return cartItemService.getCartItemsByUserId(userId);
    }

    @DeleteMapping("/{itemId}")
    public void removeItem(@PathVariable Long itemId) {
        cartItemService.removeItem(itemId);
    }

    @DeleteMapping("/clear/{userId}")
    public void clearCart(@PathVariable Long userId) {
        cartItemService.clearCart(userId);
    }
}

