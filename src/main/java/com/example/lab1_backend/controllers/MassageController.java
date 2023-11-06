package com.example.lab1_backend.controllers;

import com.example.lab1_backend.dtos.MassageDTO;
import com.example.lab1_backend.entities.Massage;
import com.example.lab1_backend.entities.User;
import com.example.lab1_backend.services.MassageService;
import com.example.lab1_backend.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/messages")
public class MassageController {

    @Autowired
    private MassageService massageService;

    @GetMapping
    public ResponseEntity<List<MassageDTO>> getAllMassages() {
        List<Massage> massages = massageService.getAllMassages();
        List<MassageDTO> massageDTOs = massages.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(massageDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MassageDTO> getMassageById(@PathVariable Long id) {
        Massage massage = massageService.getMassageById(id);
        if (massage != null) {
            return ResponseEntity.ok(convertToDTO(massage));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<MassageDTO> createMassage(@RequestBody MassageDTO massageDTO) {
        Massage massage = convertToEntity(massageDTO);
        Massage createdMassage = massageService.createMassage(massage);
        return ResponseEntity.ok(convertToDTO(createdMassage));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MassageDTO> updateMassage(@PathVariable Long id, @RequestBody MassageDTO updatedMassageDTO) {
        Massage updatedMassage = convertToEntity(updatedMassageDTO);
        Massage updated = massageService.updateMassage(id, updatedMassage);
        if (updated != null) {
            return ResponseEntity.ok(convertToDTO(updated));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMassage(@PathVariable Long id) {
        boolean deleted = massageService.deleteMassage(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private MassageDTO convertToDTO(Massage massage) {
        MassageDTO dto = new MassageDTO();
        dto.setId(massage.getId());
        dto.setReceiverId(massage.getReceiver().getId());
        dto.setSenderId(massage.getSender().getId());
        return dto;
    }

    private Massage convertToEntity(MassageDTO massageDTO) {
        UserServiceImpl userController = new UserServiceImpl();
        Massage massage = new Massage();
        massage.setId(massageDTO.getId());
        massage.setReceiver(userController.getUserById(massageDTO.getReceiverId()));
        massage.setSender(userController.getUserById(massageDTO.getSenderId()));
        return massage;
    }
}
