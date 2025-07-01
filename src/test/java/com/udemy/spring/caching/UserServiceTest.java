package com.udemy.spring.caching;

import com.udemy.spring.caching.domain.User;
import com.udemy.spring.caching.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
class UserServiceTest extends AbstractTest {
    @Autowired
    private UserService service;

    @Test
    void get() {
        User user1 = service.create(new User("Vasya", "vasya@mail.ru"));
        User user2 = service.create(new User("Kolya", "kolya@mail.ru"));

        getAndPrint(user1.getId());
        getAndPrint(user2.getId());
        getAndPrint(user1.getId());
        getAndPrint(user2.getId());
    }

    private void getAndPrint(Long id) {
        log.info("user found: {}", service.get(id));
    }
}