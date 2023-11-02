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
public class EncounterService implements IEncounterService {
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

    @Override
    public List<Encounter> getPatientEncounters(Long patientId) {
        return encounterRepository.getEncountersByPatientId(patientId);
    }

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
    public boolean deleteEncounter(Long encounterId) {
        Optional<Encounter> encounter = encounterRepository.findById(encounterId);
        if (encounter.isPresent()) {
            encounterRepository.deleteById(encounterId);
            return true;
        }
        return false;
    }
}


