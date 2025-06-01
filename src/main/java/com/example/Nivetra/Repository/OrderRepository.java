package com.example.Nivetra.Repository;

import com.example.Nivetra.Model.Order;
import com.example.Nivetra.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUser(User user);
}
