package com.example.bugtracker.models;

import com.example.bugtracker.models.enums.Priority;
import com.example.bugtracker.models.enums.Status;
import com.example.bugtracker.models.enums.Tag;
import com.example.bugtracker.models.enums.Type;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class Issue {
    @Id
    @GeneratedValue
    private Long id;
    private Status status;

    private Priority priority;
    private Type type;

    //TODO* List<Enum> tags
    private List<Tag> tags;

    private String name;
    private String description;
    private String code;
    @ManyToOne
    @JoinColumn(name = "creator_id", nullable = false)
    private Person creator;

    @ManyToOne
    @JoinColumn(name = "assigne_id", nullable = false)
    private Person assignee;

    private Date dateCreated;
    private Date lastUpdate;

    //TODO List<Comment> comments
    @OneToMany
    @JoinColumn(name = "comment_id", nullable = false)
    private List<Comment> comments;


}
