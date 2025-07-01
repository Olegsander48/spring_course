package com.udemy.spring.caching.repository;

import com.udemy.spring.caching.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
