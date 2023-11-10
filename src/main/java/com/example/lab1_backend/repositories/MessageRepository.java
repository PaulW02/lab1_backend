package com.example.lab1_backend.repositories;


import com.example.lab1_backend.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message,Long>
{
    List<Message> findBySenderIdOrReceiverId(Long senderId, Long receiverId);
}
