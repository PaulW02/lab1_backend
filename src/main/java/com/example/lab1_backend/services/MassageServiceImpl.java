package com.example.lab1_backend.services;

import com.example.lab1_backend.entities.Massage;
import com.example.lab1_backend.repositories.MassageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MassageServiceImpl implements MassageService {
    @Autowired
    private MassageRepository massageRepository;
    @Override
    public List<Massage> getAllMassages() {
        return massageRepository.findAll();
    }
    @Override
    public Massage getMassageById(Long id) {
        Optional<Massage> massage = massageRepository.findById(id);
        return massage.orElse(null);
    }
    @Override
    public Massage createMassage(Massage massage) {
        return massageRepository.save(massage);
    }
    @Override
    public Massage updateMassage(Long id, Massage updatedMassage) {
        Optional<Massage> existingMassage = massageRepository.findById(id);
        if (existingMassage.isPresent()) {
            updatedMassage.setId(id);
            return massageRepository.save(updatedMassage);
        } else {
            return null;
        }
    }
    @Override
    public boolean deleteMassage(Long id) {
        Optional<Massage> massage = massageRepository.findById(id);
        if (massage.isPresent()) {
            massageRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

