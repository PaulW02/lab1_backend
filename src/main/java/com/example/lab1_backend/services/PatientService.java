package com.example.lab1_backend.services;

import com.example.lab1_backend.entities.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    List<Patient> getAllPatients();
    Patient getPatientById(Long id);
    Patient createPatient(String firstName, String lastName, int age);
    Patient updatePatient(Long id, Patient updatedPatient);
    boolean deletePatient(Long id);
}
