package com.udemy.spring.hibernate.repository.department;

import com.udemy.spring.hibernate.entity.Department;
import java.util.Optional;

public interface DepartmentRepository {
    Optional<Department> findById(int id);

    void save(Department department);
}
