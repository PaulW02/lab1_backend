package com.example.lab1_backend.repositories;

import com.example.lab1_backend.entities.Encounter;
import com.example.lab1_backend.entities.Observation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ObservationRepository extends JpaRepository<Observation, Long>
{
    @Query("SELECT e FROM Observation e WHERE e.patient.id = ?1")
    List<Observation> getObservationByPatientId(Long id);
    @Query("SELECT o FROM Observation o WHERE o.encounter.id = :encounterId")
    List<Observation> findByEncounterId(Long encounterId);

}
