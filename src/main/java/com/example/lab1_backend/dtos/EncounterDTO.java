package com.example.lab1_backend.dtos;

import com.example.lab1_backend.entities.Encounter;
import com.example.lab1_backend.entities.Patient;

import java.util.Date;
import java.util.List;

public class EncounterDTO
{
    private Long id;
    private Date visitDate;
    private String encounterDetails;
    private PatientDTO patientDTO;

    private List<ObservationDTO> observations;


    public EncounterDTO()
    {

    }

    public EncounterDTO(Date visitDate, String encounterDetails, PatientDTO patient) {
        this.visitDate = visitDate;
        this.encounterDetails = encounterDetails;
        this.patientDTO = patient;
    }

    public static EncounterDTO fromEntity(Encounter entity) {
        EncounterDTO dto = new EncounterDTO();
        dto.setId(entity.getId());
        dto.setVisitDate(entity.getVisitDate());
        dto.setEncounterDetails(entity.getEncounterDetails());
        // Set other fields as needed
        return dto;
    }
    public PatientDTO getPatientDTO() {
        return patientDTO;
    }

    public void setPatientDTO(PatientDTO patientDTO) {
        this.patientDTO = patientDTO;
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
