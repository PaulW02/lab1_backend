package com.example.lab1_backend.repositories;

import com.example.lab1_backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
