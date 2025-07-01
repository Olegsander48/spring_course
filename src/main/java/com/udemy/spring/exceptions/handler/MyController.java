package com.udemy.spring.exceptions.handler;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MyController {
    @GetMapping("/divide")
    public String divide(@RequestParam int a, @RequestParam int b) {
        // Здесь не ловим исключения — они будут перехвачены глобально
        int result = a / b;
        return "Результат: " + result;
    }
}
