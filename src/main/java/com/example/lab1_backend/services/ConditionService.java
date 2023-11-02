package com.example.lab1_backend.services;

import com.example.lab1_backend.entities.Condition;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ConditionService
{
    List<Condition> getAllConditions();
    Condition getConditionById(Long id);
    Condition createCondition(Condition condition);
    Condition updateCondition(Long id, Condition updatedCondition);
    boolean deleteCondition(Long id);
}
