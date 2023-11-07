package com.example.lab1_backend.dtos;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;

public class MessageDTO {
    private Long id;
    private Long receiverId;
    private Long senderId;
    private LocalDate date;
    private String info;

    public MessageDTO(Long id, Long receiverId, Long senderId, LocalDate date,String info) {
        this.id = id;
        this.receiverId = receiverId;
        this.senderId = senderId;
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

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }
}

