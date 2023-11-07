package com.example.lab1_backend.controllers;

import com.example.lab1_backend.dtos.MessageDTO;
import com.example.lab1_backend.entities.Message;
import com.example.lab1_backend.services.MessageService;
import com.example.lab1_backend.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping
    public ResponseEntity<List<MessageDTO>> getAllMessages() {
        List<Message> messages = messageService.getAllMessages();
        List<MessageDTO> messageDTOS = messages.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(messageDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessageDTO> getMessageById(@PathVariable Long id) {
        Message message = messageService.getMessageById(id);
        if (message != null) {
            return ResponseEntity.ok(convertToDTO(message));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<MessageDTO> createMessage(@RequestBody MessageDTO messageDTO) {
        Message message = convertToEntity(messageDTO);
        Message createdMessage = messageService.createMessage(message);
        return ResponseEntity.ok(convertToDTO(createdMessage));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageDTO> updateMessage(@PathVariable Long id, @RequestBody MessageDTO updatedMessageDTO) {
        Message updatedMessage = convertToEntity(updatedMessageDTO);
        Message updated = messageService.updateMessage(id, updatedMessage);
        if (updated != null) {
            return ResponseEntity.ok(convertToDTO(updated));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable Long id) {
        boolean deleted = messageService.deleteMessage(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private MessageDTO convertToDTO(Message message) {
        MessageDTO dto = new MessageDTO(message.getId(), message.getReceiver().getId(),message.getSender().getId(),message.getDate(), message.getInfo());
        return dto;
    }

    private Message convertToEntity(MessageDTO messageDTO) {
        UserServiceImpl userController = new UserServiceImpl();
        Message message = new Message(messageDTO.getId(),userController.getUserById(messageDTO.getReceiverId()),userController.getUserById(messageDTO.getSenderId()),messageDTO.getDate(),messageDTO.getInfo());
        return message;
    }
}
