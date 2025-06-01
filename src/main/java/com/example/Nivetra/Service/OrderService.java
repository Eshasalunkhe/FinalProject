package com.example.Nivetra.Service;

import com.example.Nivetra.Model.Order;
import com.example.Nivetra.Model.User;
import com.example.Nivetra.Repository.OrderRepository;
import com.example.Nivetra.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    public Order saveOrder(Order order) {
        order.setOrderDate(new Date());
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public List<Order> getOrdersByUserId(Long userId) {
        Optional<User> userOpt = userRepository.findById(userId);
        if (userOpt.isPresent()) {
            return orderRepository.findByUser(userOpt.get());
        }
        return null;
    }
}

