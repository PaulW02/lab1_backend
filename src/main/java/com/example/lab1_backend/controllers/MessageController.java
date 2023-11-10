package com.example.lab1_backend.controllers;

import com.example.lab1_backend.dtos.CreateMessageDTO;
import com.example.lab1_backend.dtos.MessageDTO;
import com.example.lab1_backend.dtos.UserDTO;
import com.example.lab1_backend.entities.Message;
import com.example.lab1_backend.services.MessageService;
import com.example.lab1_backend.services.UserService;
import com.example.lab1_backend.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;


    @GetMapping
    public ResponseEntity<List<MessageDTO>> getAllMessages() {
        List<Message> messages = messageService.getAllMessages();
        List<MessageDTO> messageDTOS = messages.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(messageDTOS);
    }

    @GetMapping("/conversations/{userId}")
    public ResponseEntity<Map<Long, List<MessageDTO>>> getMessagesByUser(@PathVariable Long userId) {
        if (userId > 0) {
            return ResponseEntity.ok(messageService.getMessagesByUser(userId));
        }
        return null;
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

    @PostMapping("/")
    public ResponseEntity<MessageDTO> createMessage(@RequestBody CreateMessageDTO createMessageDTO) {
        Message createdMessage = messageService.createMessage(createMessageDTO.getInfo(), LocalDate.now(), createMessageDTO.getSenderId(), createMessageDTO.getReceiverId());
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
        MessageDTO dto = new MessageDTO(message.getId(), UserDTO.fromUser(message.getReceiver()), UserDTO.fromUser(message.getSender()),message.getDate(), message.getInfo());
        return dto;
    }

    private Message convertToEntity(MessageDTO messageDTO) {
        Message message = new Message(messageDTO.getInfo(), messageDTO.getDate(), UserDTO.fromUserDTO(messageDTO.getSender()), UserDTO.fromUserDTO(messageDTO.getReceiver()));
        return message;
    }

}
