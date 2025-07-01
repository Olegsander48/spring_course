package com.udemy.spring.caching.service;

import com.udemy.spring.caching.domain.User;

public interface UserService {
    User create(User user);

    User get(Long id);
}
