package com.example.lab1_backend.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "observations")
public class Observation
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private double value;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient; // Relation till Patient-entiteten

    public Observation(Long id, String type, double value, Patient patient) {
        this.id = id;
        this.type = type;
        this.value = value;
        this.patient = patient;
    }

    public Observation(String type, double value, Patient patient) {
        this.type = type;
        this.value = value;
        this.patient = patient;
    }

    public Observation() {

    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public double getValue() {
        return value;
    }
    public void setValue(double value) {
        this.value = value;
    }
}
