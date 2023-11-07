package com.example.lab1_backend.services;

import com.example.lab1_backend.entities.Encounter;
import com.example.lab1_backend.entities.Patient;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

public interface EncounterService
{
    Encounter createEncounter(Date visitDate, String encounterDetails, Patient patient);

    Encounter getEncounter(Long encounterId);

   // List<Encounter> getPatientEncounters(Long patientId);

    Encounter updateEncounter(Long encounterId, Encounter updatedEncounter);

    void deleteEncounter(Long encounterId);

    List<Encounter> getPatientEncounters(Long patientId);
}
