package com.example.lab1_backend.repositories;

import com.example.lab1_backend.entities.Encounter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EncounterRepository extends JpaRepository<Encounter, Long> {
    @Query("SELECT e FROM Encounter e WHERE e.patient.id = ?1")
    List<Encounter> getEncountersByPatientId(Long id);
}
