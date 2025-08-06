package com.udemy.spring.hibernate.repository.employee;

import com.udemy.spring.hibernate.entity.Employee;

import java.util.Collection;
import java.util.Optional;

public interface EmployeeRepository {
    Optional<Employee> findById(int id);

    Collection<Employee> findAll();

    Optional<Employee> findByName(String name);

    void save(Employee employee);

    void deleteById(int id);
}
