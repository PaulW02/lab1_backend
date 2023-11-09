package com.example.lab1_backend.services;

import com.example.lab1_backend.entities.Patient;
import com.example.lab1_backend.entities.User;
import com.example.lab1_backend.repositories.PatientRepository;
import com.example.lab1_backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PatientService patientService;
    @Override
    public User createUser(String firstname, String lastname, String password, String email, int age, String roles) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encryptedPassword = bCryptPasswordEncoder.encode(password);
        User user;
        if (firstname != null && lastname != null && password != null && email != null && age > 0 && roles != null) {
            if (roles.equals("Patient")) {
                Patient patient = patientService.createPatient(firstname, lastname, age);
                user = new User(firstname, lastname, encryptedPassword, email, age, roles, patient);
            } else {
                user = new User(firstname, lastname, encryptedPassword, email, age, roles);
            }
            return userRepository.save(user);
        }
        return null;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    public User updateUser(Long id, User updatedUser) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            updatedUser.setId(id);
            return userRepository.save(updatedUser);
        } else {
            return null;
        }
    }

    public boolean deleteUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public User loginUser(String username, String password) {
        User user = userRepository.findUserByEmail(username);

        if (user != null) {
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            if (bCryptPasswordEncoder.matches(password, user.getPassword())) {
                return user;
            }
        }
        return null;
    }
}

