package com.udemy.spring.configurations.config;

import com.udemy.spring.configurations.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DbConfig {
    @Bean
    public Person getPerson() {
        return new Person("Ivan");
    }
}
