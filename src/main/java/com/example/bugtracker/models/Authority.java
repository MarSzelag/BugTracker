package com.example.bugtracker.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Authority {
    @Id
    @GeneratedValue
    Long id;
    String name;
}
