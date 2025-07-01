package com.udemy.spring.exceptions.catching;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApp {
    public static void main(String[] args) {
        SpringApplication.run(DemoApp.class, args);
        System.out.println("Open http://localhost:8080/api/divide?a=10&b=0");
    }
}
