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
    @Autowired
    private LocaleResolver localeResolver;


    @GetMapping
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

    @GetMapping("/change-locale")
    public ModelAndView changeLocale(@RequestParam String lang, HttpServletRequest request, HttpServletResponse response) {
        Locale locale = new Locale(lang);
        localeResolver.setLocale(request, response, locale);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/"); // Redirect to the desired view
        modelAndView.addObject("message", "Locale changed successfully"); // Add any additional model data

        return modelAndView;
    }

}
