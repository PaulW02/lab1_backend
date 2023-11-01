package com.example.lab1_backend.services;

import com.example.lab1_backend.entities.Encounter;
import com.example.lab1_backend.entities.Patient;
import com.example.lab1_backend.repositories.EncounterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface IEncounterService
{
    Encounter createEncounter(Date visitDate, String encounterDetails, Patient patient);

    Encounter getEncounter(Long encounterId);

    List<Encounter> getPatientEncounters(Long patientId);

    Encounter updateEncounter(Long encounterId, Encounter updatedEncounter);

    void deleteEncounter(Long encounterId);
}
