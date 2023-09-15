package com.example.bugtracker.models;

import com.example.bugtracker.models.enums.Priority;
import com.example.bugtracker.models.enums.Status;
import com.example.bugtracker.models.enums.Type;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Issue {
    @Id
    @GeneratedValue
    Long id;
    Status status;

    Priority priority;
    Type type;
    //TODO* List<Enum> tags
    String name;
    String description;
    String code;
    /* TODO
    Person creator;
    Person assignee;
     */
    Date dateCreated;
    Date lastUpdate;
    //TODO List<Comment> comments


}
