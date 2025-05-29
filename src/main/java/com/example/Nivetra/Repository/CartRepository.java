package com.example.Nivetra.Repository;

import com.example.Nivetra.Model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<CartItem, Long> {}
