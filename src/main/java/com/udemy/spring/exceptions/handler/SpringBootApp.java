package com.udemy.spring.exceptions.handler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApp.class, args);
        System.out.println("Go to http://localhost:8080/api/divide?a=10&b=0");
    }
}
