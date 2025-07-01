package com.udemy.spring.exceptions.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/test-error")
    public String throwError() {
        throw new IllegalArgumentException("Неверный аргумент!");
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, world!";
    }
}
