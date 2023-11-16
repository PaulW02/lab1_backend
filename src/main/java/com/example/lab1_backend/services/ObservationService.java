package com.example.lab1_backend.services;

import com.example.lab1_backend.entities.Observation;

import java.util.List;
import java.util.Optional;

public interface ObservationService {
    List<Observation> getAllObservations();
    Observation getObservationById(Long id);
    Observation createObservation(Observation observation);
    Observation updateObservation(Long id, Observation updatedObservation);
    boolean deleteObservation(Long id);
    List<Observation> getObservationByEncounterId(Long id);


}
