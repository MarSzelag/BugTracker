package com.example.bugtracker.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Person {

    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
    private String realName;
    private String email;
    @ManyToMany
    @JoinTable(name="person_authorities",
    joinColumns = @JoinColumn(name = "person_id"),
    inverseJoinColumns = @JoinColumn(name = "authority_id"))
    private Set<Authority> authorities;

}
