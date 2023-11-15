package com.example.lab1_backend.controllers;

import com.example.lab1_backend.dtos.ObservationDTO;
import com.example.lab1_backend.dtos.PatientDTO;
import com.example.lab1_backend.entities.Observation;
import com.example.lab1_backend.entities.Patient;
import com.example.lab1_backend.services.ObservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/observation")
public class ObservationController {
    @Autowired
    private ObservationService observationService;

    @GetMapping
    public List<ObservationDTO> getAllObservations() {
        List<Observation> observations = observationService.getAllObservations();
        return observations.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ObservationDTO getObservationById(@PathVariable Long id) {
        Observation observation = observationService.getObservationById(id);
        return convertToDTO(observation);
    }

    @PostMapping
    public Observation createObservation(@RequestBody ObservationDTO observationDTO) {
        Observation observation = convertToEntity(observationDTO);
        return observationService.createObservation(observation);
    }

    @PutMapping("/{id}")
    public Observation updateObservation(@PathVariable Long id, @RequestBody ObservationDTO updatedObservationDTO) {
        Observation updatedObservation = convertToEntity(updatedObservationDTO);
        return observationService.updateObservation(id, updatedObservation);
    }

    @DeleteMapping("/{id}")
    public boolean deleteObservation(@PathVariable Long id) {
        return observationService.deleteObservation(id);
    }

    private ObservationDTO convertToDTO(Observation observation) {
        PatientDTO patientDTO = new PatientDTO(observation.getPatient().getId(), observation.getPatient().getFirstName(), observation.getPatient().getLastName(), observation.getPatient().getAge());
        ObservationDTO dto = new ObservationDTO(observation.getType(), observation.getValue(), patientDTO);
        return dto;
    }

     static Observation convertToEntity(ObservationDTO observationDTO) {
        Observation observation = new Observation(observationDTO.getId(), observationDTO.getType(), observationDTO.getValue(), new Patient(observationDTO.getPatientDTO().getId(), observationDTO.getPatientDTO().getFirstName(), observationDTO.getPatientDTO().getLastName(), observationDTO.getPatientDTO().getAge()));
        return observation;
    }
}
