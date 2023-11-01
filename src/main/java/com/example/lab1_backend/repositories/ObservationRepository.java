package com.example.lab1_backend.repositories;

import com.example.lab1_backend.entities.Observation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObservationRepository extends JpaRepository<Observation, Long> {
}
