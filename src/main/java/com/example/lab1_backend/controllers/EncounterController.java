package com.example.lab1_backend.controllers;


import com.example.lab1_backend.dtos.EncounterDTO;
import com.example.lab1_backend.dtos.PatientDTO;
import com.example.lab1_backend.entities.Patient;
import com.example.lab1_backend.services.EncounterService;
import com.example.lab1_backend.entities.Encounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/encounter")
public class EncounterController {
    @Autowired
    private EncounterService encounterService;
    @PostMapping("/")
    public ResponseEntity<Encounter> createEncounter(@RequestBody EncounterDTO encounterDTO) {
        Patient temp = new Patient(encounterDTO.getPatientDTO().getFirstName(),  encounterDTO.getPatientDTO().getLastName(), encounterDTO.getPatientDTO().getAge());
        Encounter encounter = encounterService.createEncounter(encounterDTO.getVisitDate(),encounterDTO.getEncounterDetails(),temp);
       // EncounterDTO newEncounter = new EncounterDTO(encounter.getVisitDate(),encounter.getEncounterDetails(),patient);
        return ResponseEntity.ok(encounter);
    }


    @GetMapping("/{encounterId}")
    public ResponseEntity<EncounterDTO> getEncounterbyId(@PathVariable Long encounterId) {
        Encounter encounter = encounterService.getEncounter(encounterId);
        EncounterDTO encounterDTO = new EncounterDTO(encounter.getVisitDate(),encounter.getEncounterDetails(),new PatientDTO(encounter.getPatient().getId(),encounter.getPatient().getFirstName(),encounter.getPatient().getLastName(),encounter.getPatient().getAge()));
        return ResponseEntity.ok(encounterDTO);
    }


    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<EncounterDTO>> getPatientEncounters(@PathVariable Long patientId) {
        List<Encounter> patientEncounters = encounterService.getPatientEncounters(patientId);
        List<EncounterDTO> returnValue = new ArrayList<>();
        for (int i = 0; i < patientEncounters.size(); i++)
        {
            Date visitDate = patientEncounters.get(i).getVisitDate();
            String detail = patientEncounters.get(i).getEncounterDetails();
            Patient p = patientEncounters.get(i).getPatient();
            PatientDTO patientDTO = new PatientDTO(p.getId(),p.getFirstName(),p.getLastName(),p.getAge());

            returnValue.add( new  EncounterDTO(visitDate,detail,patientDTO));
        }

        return ResponseEntity.ok(returnValue);
    }


    @PutMapping("/{encounterId}")
    public ResponseEntity<Encounter> updateEncounter(@PathVariable Long encounterId, @RequestBody EncounterDTO updatedEncounter) {

        Encounter encounter = new Encounter(updatedEncounter.getId(),updatedEncounter.getVisitDate(),updatedEncounter.getEncounterDetails(),new Patient(updatedEncounter.getPatientDTO().getId(),updatedEncounter.getPatientDTO().getFirstName(),updatedEncounter.getPatientDTO().getLastName(),updatedEncounter.getPatientDTO().getAge()));
        Encounter updated = encounterService.updateEncounter(encounterId, encounter);
        return ResponseEntity.ok(updated);
    }


    @DeleteMapping("/{encounterId}")
    public boolean deleteEncounter(@PathVariable Long encounterId) {
      return encounterService.deleteEncounter(encounterId);

    }
}
