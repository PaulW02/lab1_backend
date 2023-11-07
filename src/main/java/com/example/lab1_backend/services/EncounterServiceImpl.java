package com.example.lab1_backend.services;

import com.example.lab1_backend.entities.Encounter;
import com.example.lab1_backend.entities.Patient;
import com.example.lab1_backend.repositories.EncounterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EncounterServiceImpl implements EncounterService {
    @Autowired
    private EncounterRepository encounterRepository;

    @Override
    public Encounter createEncounter(Date visitDate, String encounterDetails, Patient patient) {
        Encounter encounter = new Encounter(visitDate, encounterDetails, patient);
        return encounterRepository.save(encounter);
    }

    @Override
    public Encounter getEncounter(Long encounterId) {
        Optional<Encounter> encounter = encounterRepository.findById(encounterId);
        return encounter.orElse(null);
    }
    /*
    @Override
    public List<Encounter> getPatientAll(Long patientId) {
        // Implementera hämtning av alla möten för en specifik patient
        // Du kan använda encounterRepository för att hämta dessa möten
        return encounterRepository.findByPatientId(patientId);
    }*/

    @Override
    public Encounter updateEncounter(Long encounterId, Encounter updatedEncounter) {
        Optional<Encounter> existingEncounter = encounterRepository.findById(encounterId);
        if (existingEncounter.isPresent()) {
            updatedEncounter.setId(encounterId);
            return encounterRepository.save(updatedEncounter);
        } else {
            return null;
        }
    }

    @Override
    public void deleteEncounter(Long encounterId) {
        encounterRepository.deleteById(encounterId);
    }

    @Override
    public List<Encounter> getPatientEncounters(Long patientId) {
        return null;
    }
}


