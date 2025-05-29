package com.example.Nivetra.Repository;

import com.example.Nivetra.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {}
