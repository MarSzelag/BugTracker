package com.example.bugtracker.repositories;

import com.example.bugtracker.models.Person;
import com.example.bugtracker.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>, JpaSpecificationExecutor<Person> {

}
