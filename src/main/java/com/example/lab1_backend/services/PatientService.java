package com.example.lab1_backend.services;

import com.example.lab1_backend.dtos.PatientDetailsDTO;
import com.example.lab1_backend.entities.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    List<Patient> getAllPatients();

    Patient getPatientById(Long id);

    Patient createPatient(String firstName, String lastName, int age);

    Patient updatePatient(Long id, Patient updatedPatient);

    boolean deletePatient(Long id);

    List<Patient> getPatientByFirstNameAndLastName(String firstName, String lastName);

    PatientDetailsDTO getPatientDetailsById(Long id);
    Patient getPatientByUserId(Long id);



}


