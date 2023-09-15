package com.example.bugtracker.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity

public class Person {

    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
    private String realName;
    private String email;
    // TODO Set<Authority> authorities
}
