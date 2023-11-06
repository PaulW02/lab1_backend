package com.example.lab1_backend.services;

import com.example.lab1_backend.entities.Message;
import com.example.lab1_backend.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageRepository messageRepository;
    @Override
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }
    @Override
    public Message getMessageById(Long id) {
        Optional<Message> message = messageRepository.findById(id);
        return message.orElse(null);
    }
    @Override
    public Message createMessage(Message message) {
        return messageRepository.save(message);
    }
    @Override
    public Message updateMessage(Long id, Message updatedMessage) {
        Optional<Message> existingMessage = messageRepository.findById(id);
        if (existingMessage.isPresent()) {
            updatedMessage.setId(id);
            return messageRepository.save(updatedMessage);
        } else {
            return null;
        }
    }
    @Override
    public boolean deleteMessage(Long id) {
        Optional<Message> message = messageRepository.findById(id);
        if (message.isPresent()) {
            messageRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

