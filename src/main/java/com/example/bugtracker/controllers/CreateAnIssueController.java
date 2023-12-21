package com.example.bugtracker.controllers;
import jakarta.validation.Valid;
import com.example.bugtracker.repositories.IssueRepository;
import com.example.bugtracker.services.ProjectService;
import com.example.bugtracker.models.Issue;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CreateAnIssueController {

    private final IssueRepository issueRepository;
    private final ProjectService projectService;

    @GetMapping
    ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("issues/index");
        List<Issue> issues = issueRepository.findAll();
        modelAndView.addObject("issues", issues);
        return modelAndView;
    }
    @GetMapping("/create")
    ModelAndView create(){
        ModelAndView modelAndView = new ModelAndView("issues/create");

        Issue newIssue = new Issue();

        modelAndView.addObject("issue", newIssue);
        modelAndView.addObject("projects", projectService.findAll());
        return modelAndView;
    }

    @PostMapping("/save")
    ModelAndView save(@ModelAttribute @Valid Issue issue, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView("redirect:/issues");

        if(bindingResult.hasErrors()){
            modelAndView.setViewName("issues/create");
            modelAndView.addObject("projects", projectService.findAll());
            return modelAndView;
        }
        issueRepository.save(issue);
        return modelAndView;
    }
}
