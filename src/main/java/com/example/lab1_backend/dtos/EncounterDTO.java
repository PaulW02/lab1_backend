package com.example.lab1_backend.dtos;

import com.example.lab1_backend.entities.Patient;

import java.util.Date;

public class EncounterDTO
{
    private Long id;
    private Date visitDate;
    private String encounterDetails;
    private PatientDTO patientDTO;
    public EncounterDTO(Date visitDate, String encounterDetails, PatientDTO patient) {
        this.visitDate = visitDate;
        this.encounterDetails = encounterDetails;
        this.patientDTO = patient;
    }

    // Getter- och setter-metoder för attributen

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public String getEncounterDetails() {
        return encounterDetails;
    }

    public void setEncounterDetails(String encounterDetails) {
        this.encounterDetails = encounterDetails;
    }


}
