package com.example.bugtracker.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Comment {
    @Id
    @GeneratedValue
    Long id;
    Date dateCreated;
    //TODO Person author;
    String content;
}
