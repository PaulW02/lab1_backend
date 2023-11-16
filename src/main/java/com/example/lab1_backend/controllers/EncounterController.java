package com.example.lab1_backend.controllers;


import com.example.lab1_backend.dtos.EncounterDTO;
import com.example.lab1_backend.dtos.ObservationDTO;
import com.example.lab1_backend.dtos.PatientDTO;
import com.example.lab1_backend.entities.Observation;
import com.example.lab1_backend.entities.Patient;
import com.example.lab1_backend.services.EncounterService;
import com.example.lab1_backend.entities.Encounter;
import com.example.lab1_backend.services.ObservationService;
import com.example.lab1_backend.services.ObservationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/encounter")
public class EncounterController {
    @Autowired
    private EncounterService encounterService;
    @Autowired
    private ObservationService  observationService;

    @PostMapping("/")
    public ResponseEntity<EncounterDTO> createEncounter(@RequestBody Date visitDate, String encounterDetails, PatientDTO patient) {
        Encounter encounter = encounterService.createEncounter(visitDate,encounterDetails,new Patient(patient.getFirstName(), patient.getLastName(), patient.getAge()));
        EncounterDTO newEncounter = new EncounterDTO(encounter.getVisitDate(),encounter.getEncounterDetails(),patient);
        return ResponseEntity.ok(newEncounter);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EncounterDTO> getEncounterbyId(@PathVariable Long id) {
        Encounter encounter = encounterService.getEncounter(id);
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
    public void deleteEncounter(@PathVariable Long encounterId) {
      encounterService.deleteEncounter(encounterId);
    }

    @GetMapping("/{id}/observations")
    public ResponseEntity<List<ObservationDTO>> getObservationDTOByEncounterId(@PathVariable Long id) {


        List<Observation> observations = observationService.getObservationByEncounterId(id);
        List<ObservationDTO> dtos = new ArrayList<>();

        for (int i = 0; i < observations.size(); i++) {
            PatientDTO patientDTO = new PatientDTO(observations.get(i).getPatient().getId(), observations.get(i).getPatient().getFirstName(), observations.get(i).getPatient().getLastName(), observations.get(i).getPatient().getAge());
            ObservationDTO dto = new ObservationDTO(observations.get(i).getType(), observations.get(i).getValue(), patientDTO);
            dtos.add(dto);
        }

        //dtos.add(new ObservationDTO("cancer",23,new PatientDTO(1,"george","bahadi",)))
        return ResponseEntity.ok(dtos);
    }

}
