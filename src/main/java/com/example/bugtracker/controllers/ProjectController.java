package com.example.bugtracker.controllers;

import com.example.bugtracker.models.Person;
import com.example.bugtracker.models.Project;
import com.example.bugtracker.services.PersonService;
import com.example.bugtracker.services.ProjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {
    final private ProjectService projectService;
    final private PersonService personService;


    @GetMapping
    ModelAndView index(@ModelAttribute ProjectFilter filter, Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("projects/index");
        Page<Project> projects = projectService.findAll(filter.buildSpecification(), pageable);
        modelAndView.addObject("projects", projects);
        List<Person> people = personService.findAll();
        modelAndView.addObject("people", people);
        modelAndView.addObject("filter", filter);
        return modelAndView;
    }

    @GetMapping("/save")
    ModelAndView save(@ModelAttribute @Valid Project project, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView("redirect:/projects");

        if(bindingResult.hasErrors()){
            modelAndView.setViewName("projects/create");
            modelAndView.addObject("project", project);
            modelAndView.addObject("people", personService.findAll());
            return modelAndView;
        }
        projectService.save(project);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    ModelAndView delete(@PathVariable Long id){
        System.out.println("usuwanie projektu " + id);
        projectService.delete(id);
        return new ModelAndView(("redirect:/projects"));
    }

}
