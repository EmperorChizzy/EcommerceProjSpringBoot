package com.example.ecommerceprojspringboot.repositories;

import com.example.ecommerceprojspringboot.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepositories extends JpaRepository<Order, Long> {

}
