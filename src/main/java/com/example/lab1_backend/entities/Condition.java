package com.example.lab1_backend.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "conditions")
public class Condition
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String conditionName;
    // Lägg till andra attribut för medicinskt tillstånd

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient; // Medicinskt tillstånd hör till en patient

    // Getter och setters

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

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
