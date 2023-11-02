package com.example.lab1_backend.services;

import com.example.lab1_backend.entities.Condition;
import com.example.lab1_backend.entities.Observation;
import com.example.lab1_backend.repositories.ConditionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConditionService implements IConditionService
{
    @Autowired
    private ConditionRepository conditionRepository;
    @Override
    public List<Condition> getAllConditions() {
       return conditionRepository.findAll();
    }

    @Override
    public Condition getConditionById(Long id) {
        Optional<Condition> condition =conditionRepository.findById(id);;
        return condition.orElse(null);
    }

    @Override
    public Condition createCondition(Condition condition) {
        return conditionRepository.save(condition);
    }

    @Override
    public Condition updateCondition(Long id, Condition updatedCondition) {
        Optional<Condition> existingCondition = conditionRepository.findById(id);
        if (existingCondition.isPresent()) {
            updatedCondition.setId(id);
            return conditionRepository.save(updatedCondition);
        } else {
            return null; // Eller så kan du hantera ett eventuellt fel på ett annat sätt
        }
    }

    @Override
    public boolean deleteCondition(Long id) {
        Optional<Condition> condition = conditionRepository.findById(id);
        if (condition.isPresent()) {
            conditionRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
