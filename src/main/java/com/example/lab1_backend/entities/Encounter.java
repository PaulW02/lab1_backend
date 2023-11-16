package com.example.lab1_backend.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "encounters")
public class Encounter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date visitDate;
    private String encounterDetails;
    // Lägg till andra attribut som är relevanta för en träff


    @OneToMany(mappedBy = "encounter")
    private List<Observation> observations = new ArrayList<>();



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient; // Relation till Patient-entiteten


    public Encounter(Date visitDate, String encounterDetails, Patient patient) {
        this.visitDate = visitDate;
        this.encounterDetails = encounterDetails;
        this.patient = patient;
    }

    public Encounter(Long id, Date visitDate, String encounterDetails, Patient patient) {
        this.id = id;
        this.visitDate = visitDate;
        this.encounterDetails = encounterDetails;
        this.patient = patient;
    }

    public Encounter() {

    }


    public List<Observation> getObservations() {
        return observations;
    }

    public void setObservations(ArrayList<Observation> observations) {
        this.observations = observations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEncounterDetails() {
        return encounterDetails;
    }

    public void setEncounterDetails(String encounterDetails) {
        this.encounterDetails = encounterDetails;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }
}

