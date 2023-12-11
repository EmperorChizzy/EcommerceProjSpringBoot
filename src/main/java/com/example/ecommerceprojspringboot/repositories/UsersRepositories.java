package com.example.ecommerceprojspringboot.repositories;

import com.example.ecommerceprojspringboot.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepositories extends JpaRepository<Users, Long> {
    Optional<Users> findByUsername(String username);
}
