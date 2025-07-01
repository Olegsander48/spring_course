package com.udemy.spring.exceptions.catching;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoController {

    @GetMapping("/divide")
    public String divide(@RequestParam int a, @RequestParam int b) {
        try {
            int result = a / b;
            return "Результат: " + result;
        } catch (ArithmeticException ex) {
            return "Ошибка: деление на ноль запрещено!";
        }
    }
}
