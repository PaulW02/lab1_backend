package com.example.lab1_backend.services;

import com.example.lab1_backend.entities.Massage;

import java.util.List;

public interface MassageService
{
    List<Massage> getAllMassages();
    Massage getMassageById(Long id);
    Massage createMassage(Massage massage);
    Massage updateMassage(Long id, Massage updatedMassage);
    boolean deleteMassage(Long id);
}
