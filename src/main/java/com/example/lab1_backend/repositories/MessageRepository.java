package com.example.lab1_backend.repositories;


import com.example.lab1_backend.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message,Long>
{

}
