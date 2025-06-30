package com.udemy.spring.events.service;

import com.udemy.spring.events.UserRegisteredEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @EventListener
    public void handleUserRegistered(UserRegisteredEvent event) {
        System.out.println("Отправка письма на: " + event.getEmail());
    }
}
