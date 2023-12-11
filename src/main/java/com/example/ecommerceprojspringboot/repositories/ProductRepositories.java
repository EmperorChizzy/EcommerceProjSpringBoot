package com.example.ecommerceprojspringboot.repositories;


import com.example.ecommerceprojspringboot.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepositories extends JpaRepository<Product, Long>{
    List<Product> findByCategories(String categories);
}
