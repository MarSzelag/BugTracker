package com.example.bugtracker.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;

import java.util.Locale;
@Controller
public class LocaleController {
    @Autowired
    private LocaleResolver localeResolver;
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
