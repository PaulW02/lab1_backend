package com.example.lab1_backend.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "messages")
public class Message
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id", nullable = false)
    private User receiver;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver_id", nullable = false)
    private User sender;

    private LocalDate date;

    public Message(Long id, User receiver, User sender, LocalDate date) {
        this.id = id;
        this.receiver = receiver;
        this.sender = sender;
        this.date = date;
    }


    public Message(Long id, User receiver, User sender) {
        this.id = id;
        this.receiver = receiver;
        this.sender = sender;
        this.date = LocalDate.now();
    }

    public Message() {

    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
