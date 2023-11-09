package com.example.lab1_backend.controllers;

import com.example.lab1_backend.dtos.PatientDTO;
import com.example.lab1_backend.dtos.SearchPatientDTO;
import com.example.lab1_backend.entities.Patient;
import com.example.lab1_backend.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    // Inject your service or repository here
    @Autowired
    private PatientService patientService;

    // Define your REST endpoints
    @GetMapping
    public List<PatientDTO> getAllPatients() {
        List<Patient> patients = patientService.getAllPatients();
        return new ArrayList<>();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> getPatientById(@PathVariable Long id) {
        Patient patient = patientService.getPatientById(id);
        if (patient != null) {
            PatientDTO patientDTO = new PatientDTO(patient.getId(), patient.getFirstName(), patient.getLastName(), patient.getAge());
            return ResponseEntity.ok(patientDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<PatientDTO> createPatient(@RequestBody PatientDTO patient) {
        Patient createdPatient = patientService.createPatient(patient.getFirstName(), patient.getLastName(), patient.getAge());
        PatientDTO createdPatientDTO = new PatientDTO(createdPatient.getId(), createdPatient.getFirstName(), createdPatient.getLastName(), createdPatient.getAge());
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPatientDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        boolean deleted = patientService.deletePatient(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/search")
    public ResponseEntity<List<PatientDTO>> findPatientByFirstNameAndLastName(
            @RequestParam String firstName,
            @RequestParam String lastName) {
        List<Patient> patients = patientService.getPatientByFirstNameAndLastName(firstName, lastName);
        List<PatientDTO> patientDTOS = new ArrayList<>();
        for (Patient patient: patients) {
            patientDTOS.add(new PatientDTO(patient.getId(),patient.getFirstName(), patient.getLastName(), patient.getAge()));
        }
        if (patientDTOS != null) {
            return ResponseEntity.ok(patientDTOS);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
