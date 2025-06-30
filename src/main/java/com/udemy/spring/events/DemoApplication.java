package com.udemy.spring.events;

import com.udemy.spring.events.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(EventsConfig.class);
        UserService userService = context.getBean(UserService.class);
        userService.registerUser("test@example.com");
    }
}
