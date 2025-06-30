package com.udemy.spring.events.service;

import com.udemy.spring.events.UserRegisteredEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final ApplicationEventPublisher publisher;

    public UserService(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void registerUser(String email) {
        System.out.println("Пользователь зарегистрирован: " + email);
        publisher.publishEvent(new UserRegisteredEvent(this, email));
    }
}
