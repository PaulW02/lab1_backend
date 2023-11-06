package com.example.lab1_backend.services;

import com.example.lab1_backend.entities.Message;

import java.util.List;

public interface MessageService
{
    List<Message> getAllMessages();
    Message getMessageById(Long id);
    Message createMessage(Message message);
    Message updateMessage(Long id, Message updatedMessage);
    boolean deleteMessage(Long id);
}
