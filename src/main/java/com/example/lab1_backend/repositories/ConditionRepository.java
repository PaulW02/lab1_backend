package com.example.lab1_backend.repositories;

import com.example.lab1_backend.entities.Condition;
import com.example.lab1_backend.entities.Encounter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConditionRepository  extends JpaRepository<Condition,Long>
{

}
