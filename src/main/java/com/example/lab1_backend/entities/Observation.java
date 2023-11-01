package com.example.lab1_backend.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "observations")
public class Observation
{

    private Long id;
    private String observationDetails;
    // Lägg till andra attribut som är relevanta för observationen

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient; // Relation till Patient-entiteten
    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

    public String getObservationDetails() {
        return observationDetails;
    }

    public void setObservationDetails(String observationDetails) {
        this.observationDetails = observationDetails;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
