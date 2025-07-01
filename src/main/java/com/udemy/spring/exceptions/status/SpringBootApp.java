package com.udemy.spring.exceptions.status;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApp.class, args);
        System.out.println("User found: http://localhost:8080/users/1");
        System.out.println("User not found: http://localhost:8080/users/2");
    }
}
