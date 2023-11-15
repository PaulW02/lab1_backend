package com.example.lab1_backend.dtos;

public class CreateObservationDTO {

    private String type;
    private double value;
    private Long patientId;

    public CreateObservationDTO(String type, double value, Long patientId) {
        this.type = type;
        this.value = value;
        this.patientId = patientId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }
}
