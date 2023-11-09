package com.example.lab1_backend.repositories;

import com.example.lab1_backend.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long>
{
     @Query("SELECT e FROM Patient e WHERE e.firstName = :firstName AND e.lastName = :lastName")
     List<Patient> findByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);

}
