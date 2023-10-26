package com.example.bugtracker.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Project {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    //TODO Set<Issue> Issues @ManyToOne ale trzeba zrobić po stronie Issue lub @OneToManyTutaj
    private Boolean enabled;
    private Date dateCreated;
    private String code;
    private String description;
    @ManyToOne
    @JoinColumn(name="creator_id", nullable = false)
    private Person creator;
}
