package com.example.lab1_backend.services;

import com.example.lab1_backend.entities.Message;

import java.time.LocalDate;
import java.util.List;

public interface MessageService
{
    List<Message> getAllMessages();
    Message getMessageById(Long id);
    Message updateMessage(Long id, Message updatedMessage);
    boolean deleteMessage(Long id);

    Message createMessage(String info, LocalDate date, Long senderId, Long receiverId);
}
