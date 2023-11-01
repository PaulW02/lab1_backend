package com.example.lab1_backend.controllers;


import com.example.lab1_backend.dtos.EncounterDTO;
import com.example.lab1_backend.dtos.PatientDTO;
import com.example.lab1_backend.entities.Patient;
import com.example.lab1_backend.services.EncounterService;
import com.example.lab1_backend.entities.Encounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/encounter")
public class EncounterController {
    @Autowired
    private EncounterService encounterService;
//DUBELL kolla detta
    @PostMapping("/")
    public ResponseEntity<EncounterDTO> createEncounter(@RequestBody Date visitDate, String encounterDetails, PatientDTO patient) {
        Encounter encounter = encounterService.createEncounter(visitDate,encounterDetails,new Patient(patient.getFirstName(), patient.getLastName(), patient.getAge()));
        EncounterDTO newEncounter = new EncounterDTO(encounter.getVisitDate(),encounter.getEncounterDetails(),patient);
        return ResponseEntity.ok(newEncounter);
    }


    @GetMapping("/{encounterId}")
    public ResponseEntity<Encounter> getEncounter(@PathVariable Long encounterId) {
        Encounter encounter = encounterService.getEncounter(encounterId);
        return ResponseEntity.ok(encounter);
    }


   /* @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<Encounter>> getPatientEncounters(@PathVariable Long patientId) {
        List<Encounter> patientEncounters = encounterService.getPatientEncounters(patientId);
        return ResponseEntity.ok(patientEncounters);
    }*/


    @PutMapping("/{encounterId}")
    public ResponseEntity<Encounter> updateEncounter(@PathVariable Long encounterId, @RequestBody Encounter updatedEncounter) {
        Encounter updated = encounterService.updateEncounter(encounterId, updatedEncounter);
        return ResponseEntity.ok(updated);
    }


    @DeleteMapping("/{encounterId}")
    public ResponseEntity<Void> deleteEncounter(@PathVariable Long encounterId) {
        encounterService.deleteEncounter(encounterId);
        return ResponseEntity.noContent().build();
    }
}
