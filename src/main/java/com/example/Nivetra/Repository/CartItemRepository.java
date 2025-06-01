package com.example.Nivetra.Repository;

import com.example.Nivetra.Model.CartItem;
import com.example.Nivetra.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByUser(User user);
}
