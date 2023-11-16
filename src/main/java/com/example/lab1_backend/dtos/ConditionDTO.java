package com.example.lab1_backend.dtos;

import com.example.lab1_backend.entities.Condition;
import com.example.lab1_backend.entities.Patient;


public class ConditionDTO
{
    private Long id;
    private String conditionName;
    private PatientDTO patient;

    public ConditionDTO() {
    }

    public ConditionDTO(String conditionName, PatientDTO patient) {
        this.conditionName = conditionName;
        this.patient = patient;
    }


    public ConditionDTO(Long id, String conditionName, PatientDTO patient) {
        this.id = id;
        this.conditionName = conditionName;
        this.patient = patient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConditionName() {
        return conditionName;
    }

    public void setConditionName(String conditionName) {
        this.conditionName = conditionName;
    }

    public PatientDTO getPatient() {
        return patient;
    }

    public void setPatient(PatientDTO patient) {
        this.patient = patient;
    }
    public static ConditionDTO fromEntity(Condition entity) {
        ConditionDTO dto = new ConditionDTO();
        dto.setId(entity.getId());
        dto.setConditionName(entity.getConditionName());
        return dto;
    }
}
