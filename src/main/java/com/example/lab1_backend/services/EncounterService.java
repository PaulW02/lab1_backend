package com.example.lab1_backend.services;

import com.example.lab1_backend.entities.Encounter;

import java.time.LocalDate;
import java.util.List;

public interface EncounterService
{
    Encounter createEncounter(LocalDate visitDate, Long patient);

    Encounter getEncounter(Long encounterId);

   // List<Encounter> getPatientEncounters(Long patientId);

    Encounter updateEncounter(Long encounterId, Encounter updatedEncounter);

    void deleteEncounter(Long encounterId);

    List<Encounter> getPatientEncounters(Long patientId);

}
