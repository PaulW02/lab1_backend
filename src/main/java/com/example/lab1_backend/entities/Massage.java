package com.example.lab1_backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "massages")
public class Massage
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id" )
    private User receiver;

    @OneToOne
    @JoinColumn(name = "user_id" )
    private User sender;

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




}
