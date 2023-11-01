package com.example.lab1_backend.dtos;

import com.example.lab1_backend.entities.Condition;
import com.example.lab1_backend.entities.Encounter;
import com.example.lab1_backend.entities.Observation;
import jakarta.persistence.OneToMany;

import java.util.List;

public class PatientDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private int age;

    public PatientDTO(Long id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
