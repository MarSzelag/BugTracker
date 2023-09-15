package com.example.bugtracker.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Project {
    @Id
    @GeneratedValue
    Long id;
    String name;
    //TODO Set<Issue> Issues
    Boolean enabled;
    Date dateCreated;
    String code;
    String description;
    //TODO* Person creator;
}
