package com.example.lab1_backend.repositories;

import com.example.lab1_backend.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
