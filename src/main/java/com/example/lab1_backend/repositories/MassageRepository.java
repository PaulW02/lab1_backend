package com.example.lab1_backend.repositories;


import com.example.lab1_backend.entities.Massage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MassageRepository extends JpaRepository<Massage,Long>
{

}
