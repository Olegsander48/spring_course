package com.udemy.spring.caching;

import com.udemy.spring.caching.domain.User;
import com.udemy.spring.caching.service.UserService;
import jakarta.persistence.EntityNotFoundException;
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

    @Test
    void create() {
        createAndPrint("Ivan", "ivan@mail.ru");
        createAndPrint("Ivan", "ivan1122@mail.ru");
        createAndPrint("Sergey", "ivan@mail.ru");

        log.info("all entries are below:");
        service.getAll().forEach(u -> log.info("{}", u.toString()));
    }

    @Test
    void createAndRefresh() {
        User user1 = service.createOrReturnCached(new User("Vasya", "vasya@mail.ru"));
        log.info("created user1: {}", user1);

        User user2 = service.createOrReturnCached(new User("Vasya", "misha@mail.ru"));
        log.info("created user2: {}", user2);

        User user3 = service.createAndRefreshCache(new User("Vasya", "kolya@mail.ru"));
        log.info("created user3: {}", user3);

        User user4 = service.createOrReturnCached(new User("Vasya", "petya@mail.ru"));
        log.info("created user4: {}", user4);
    }

    @Test
    void delete() {
        User user1 = service.create(new User("Vasya", "vasya@mail.ru"));
        log.info("{}", service.get(user1.getId()));

        User user2 = service.create(new User("Vasya", "vasya@mail.ru"));
        log.info("{}", service.get(user2.getId()));

        service.delete(user1.getId());
        service.deleteAndEvict(user2.getId());

        log.info("{}", service.get(user1.getId()));
        try {
            log.info("{}", service.get(user2.getId()));
        } catch (EntityNotFoundException ex) {
            log.error("Method throws exception: " + ex.getMessage());
        }
    }

    private void createAndPrint(String name, String email) {
        log.info("created user: {}", service.create(name, email));
    }

    private void getAndPrint(Long id) {
        log.info("user found: {}", service.get(id));
    }
}