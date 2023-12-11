package com.example.bugtracker.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;

import java.util.Locale;

@Controller
@AllArgsConstructor
@RequestMapping("index")
public class IndexController {


    @GetMapping
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }



}
