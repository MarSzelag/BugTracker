package com.example.bugtracker;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration

public class MessageConfig implements WebMvcConfigurer {


    @Bean
    public LocaleResolver localeResolver() { //Set the way date related operations should behave according to region or country selected.
        SessionLocaleResolver slr = new SessionLocaleResolver();
        //slr.setDefaultLocale(new Locale("pl", "PL"));
        slr.setDefaultLocale(new Locale("en","GB"));
        return slr;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() { //Handle locale change requests.
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) { //This is used for registering new interceptors. Interceptor is a component that allows to intercept and process HTTP requests and responses.
        registry.addInterceptor(localeChangeInterceptor());
    }
}
