package com.example.lab1_backend.controllers;

import com.example.lab1_backend.dtos.ConditionDTO;
import com.example.lab1_backend.dtos.PatientDTO;
import com.example.lab1_backend.entities.Condition;
import com.example.lab1_backend.entities.Patient;
import com.example.lab1_backend.services.ConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/condition")
public class ConditionController {
    @Autowired
    private ConditionService conditionService;

    @GetMapping
    public List<ConditionDTO> getAllConditions() {
        List<Condition> conditions = conditionService.getAllConditions();
        return conditions.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ConditionDTO getConditionById(@PathVariable Long id) {
        Condition condition = conditionService.getConditionById(id);
        return convertToDTO(condition);
    }

    @PostMapping
    public Condition createCondition(@RequestBody ConditionDTO conditionDTO) {
        Condition condition = convertToEntity(conditionDTO);
        return conditionService.createCondition(condition);
    }

    @PutMapping("/{id}")
    public Condition updateCondition(@PathVariable Long id, @RequestBody ConditionDTO updatedConditionDTO) {
        Condition updatedCondition = convertToEntity(updatedConditionDTO);
        return conditionService.updateCondition(id, updatedCondition);
    }

    @DeleteMapping("/{id}")
    public boolean deleteCondition(@PathVariable Long id) {
        return conditionService.deleteCondition(id);
    }

    private ConditionDTO convertToDTO(Condition condition) {
        PatientDTO patientDTO = new PatientDTO(condition.getPatient().getId(), condition.getPatient().getFirstName(), condition.getPatient().getLastName(), condition.getPatient().getAge());
        ConditionDTO dto = new ConditionDTO(condition.getId(), condition.getConditionName(), patientDTO);
        return dto;
    }

    private Condition convertToEntity(ConditionDTO conditionDTO) {
        Condition condition = new Condition(conditionDTO.getId(), conditionDTO.getConditionName(), new Patient(conditionDTO.getPatient().getId(), conditionDTO.getPatient().getFirstName(), conditionDTO.getPatient().getLastName(), conditionDTO.getPatient().getAge()));
        return condition;
    }
}

