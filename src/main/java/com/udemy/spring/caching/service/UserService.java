package com.udemy.spring.caching.service;

import com.udemy.spring.caching.domain.User;

import java.util.List;

public interface UserService {
    User create(User user);

    User get(Long id);

    User create(String name, String email);

    List<User> getAll();

    User createOrReturnCached(User user);

    User createAndRefreshCache(User user);
}
