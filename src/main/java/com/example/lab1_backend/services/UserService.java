package com.example.lab1_backend.services;

import com.example.lab1_backend.entities.User;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserService {
    User createUser(String firstname, String lastname, String password, String email, int age, String roles);
    List<User> getAllUsers();
    User getUserById(Long id);
    User updateUser(Long id, User updatedUser);
    boolean deleteUser(Long id);

    User loginUser(String username, String password);

    List<User> getAllPatients();

    List<User> getAllDoctors();

    List<User> getAllEmployees();
}
