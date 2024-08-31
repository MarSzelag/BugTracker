package com.example.bugtracker.services;

import com.example.bugtracker.models.Person;
import com.example.bugtracker.models.Project;
import com.example.bugtracker.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {
    final private PersonRepository personRepository;
    public List<Person> findAll(){return personRepository.findAll();}
    public void delete(Long id) {personRepository.deleteById(id);}
    public String getProjectCreatorData(Project project){ return project.getCreator().getUsername();}

}
