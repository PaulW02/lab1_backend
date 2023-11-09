package com.example.lab1_backend.services;

import com.example.lab1_backend.entities.Patient;
import com.example.lab1_backend.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;


    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(Long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        return patient.orElse(null);
    }

    public Patient createPatient(String firstName, String lastName, int age) {
        Patient patient = new Patient(firstName, lastName, age);
        return patientRepository.save(patient);
    }

    public Patient updatePatient(Long id, Patient updatedPatient) {
        Optional<Patient> existingPatient = patientRepository.findById(id);
        if (existingPatient.isPresent()) {
            updatedPatient.setId(id);
            return patientRepository.save(updatedPatient);
        } else {
            return null;
        }
    }

    public boolean deletePatient(Long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        if (patient.isPresent()) {
            patientRepository.deleteById(id);
            return true;
        }
        return false;
    }
    public List<Patient> getPatientByFirstNameAndLastName(String firstName,String lastName)
    {
        return patientRepository.findByFirstNameAndLastName(firstName,lastName);
    }
}
