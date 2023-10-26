package com.example.bugtracker.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue
    private Long id;
    private Date dateCreated;
    @ManyToOne
    @JoinColumn(name = "creator_id", nullable = false)
    private Person creator;
    private String content;
}
