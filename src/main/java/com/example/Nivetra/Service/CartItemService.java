package com.example.Nivetra.Service;

import com.example.Nivetra.Model.CartItem;
import com.example.Nivetra.Model.Product;
import com.example.Nivetra.Model.User;
import com.example.Nivetra.Repository.CartItemRepository;
import com.example.Nivetra.Repository.ProductRepository;
import com.example.Nivetra.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    public CartItem addToCart(CartItem item) {
        Optional<Product> productOpt = productRepository.findById(item.getProduct().getId());
        Optional<User> userOpt = userRepository.findById(item.getUser().getId());

        if (productOpt.isPresent() && userOpt.isPresent()) {
            item.setProduct(productOpt.get());
            item.setUser(userOpt.get());
            return cartItemRepository.save(item);
        }
        return null;
    }

    public List<CartItem> getCartItemsByUserId(Long userId) {
        Optional<User> userOpt = userRepository.findById(userId);
        if (userOpt.isPresent()) {
            return cartItemRepository.findByUser(userOpt.get());
        }
        return null;
    }

    public void removeItem(Long itemId) {
        cartItemRepository.deleteById(itemId);
    }

    public void clearCart(Long userId) {
        Optional<User> userOpt = userRepository.findById(userId);
        if (userOpt.isPresent()) {
            List<CartItem> items = cartItemRepository.findByUser(userOpt.get());
            cartItemRepository.deleteAll(items);
        }
    }
}
