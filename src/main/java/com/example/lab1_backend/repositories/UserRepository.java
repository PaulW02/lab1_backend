package com.example.lab1_backend.repositories;

import com.example.lab1_backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.email = ?1 AND u.password = ?2")
    User findUserByEmailAndPassword(String email, String password);
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    User findUserByEmail(String email);
    @Query("SELECT u FROM User u WHERE u.roles = 'Patient'")
    List<User> findAllPatients();
    @Query("SELECT u FROM User u WHERE u.roles = 'Doctor'")
    List<User> findAllDoctors();
    @Query("SELECT u FROM User u WHERE u.roles = 'Employee'")
    List<User> findAllEmployees();
}
