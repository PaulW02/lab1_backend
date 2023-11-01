package com.example.lab1_backend.repositories;

import com.example.lab1_backend.entities.Encounter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EncounterRepository extends JpaRepository<Encounter,Long>
{

}
