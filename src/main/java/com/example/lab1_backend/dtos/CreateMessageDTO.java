package com.example.lab1_backend.dtos;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;

public class CreateMessageDTO {
    private Long receiverId;
    private Long senderId;
    private String info;

    public CreateMessageDTO(Long receiverId, Long senderId, LocalDate date, String info) {
        this.receiverId = receiverId;
        this.senderId = senderId;
        this.info = info;
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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}

