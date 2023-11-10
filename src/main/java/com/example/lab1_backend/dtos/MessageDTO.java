package com.example.lab1_backend.dtos;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;

public class MessageDTO {
    private Long id;
    private UserDTO receiver;
    private UserDTO sender;
    private LocalDate date;
    private String info;

    public MessageDTO(Long id, UserDTO receiver, UserDTO sender, LocalDate date,String info) {
        this.id = id;
        this.receiver = receiver;
        this.sender = sender;
        this.date = date;
        this.info    = info;
    }


    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDTO getReceiver() {
        return receiver;
    }

    public void setReceiver(UserDTO receiver) {
        this.receiver = receiver;
    }

    public UserDTO getSender() {
        return sender;
    }

    public void setSender(UserDTO sender) {
        this.sender = sender;
    }
}

