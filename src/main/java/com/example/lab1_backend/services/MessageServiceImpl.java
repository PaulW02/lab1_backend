package com.example.lab1_backend.services;

import com.example.lab1_backend.dtos.MessageDTO;
import com.example.lab1_backend.dtos.UserDTO;
import com.example.lab1_backend.entities.Message;
import com.example.lab1_backend.entities.User;
import com.example.lab1_backend.repositories.MessageRepository;
import com.example.lab1_backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;
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
    public Message createMessage(String info, LocalDate date, Long senderId, Long receiverId) {
        if (info != null && date != null && senderId != null && receiverId != null) {
            Optional<User> sender = userRepository.findById(senderId);
            Optional<User> receiver = userRepository.findById(receiverId);
            Message createdMessage = new Message(info, date, sender.get(), receiver.get());
            return messageRepository.save(createdMessage);
        }
        return null;
    }

    @Override
    public Map<Long, List<MessageDTO>> getMessagesByUser(Long userId) {
        // Retrieve messages from the repository based on the user ID
        List<Message> messages = messageRepository.findBySenderIdOrReceiverId(userId, userId);

        // Organize messages into a map where the key is the other user's ID
        Map<Long, List<MessageDTO>> messagesByUser = new HashMap<>();

        for (Message message : messages) {
            Long otherUserId = getOtherUserId(userId, message);
            messagesByUser.computeIfAbsent(otherUserId, k -> new ArrayList<>())
                    .add(convertToDTO(message));
        }

        return messagesByUser;
    }

    private MessageDTO convertToDTO(Message message) {
        MessageDTO dto = new MessageDTO(message.getId(), UserDTO.fromUser(message.getReceiver()),UserDTO.fromUser(message.getSender()),message.getDate(), message.getInfo());
        return dto;
    }

    private Long getOtherUserId(Long userId, Message message) {
        // Determine the ID of the other user in the conversation
        if (userId.equals(message.getSender().getId())) {
            return message.getReceiver().getId();
        } else {
            return message.getSender().getId();
        }
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

