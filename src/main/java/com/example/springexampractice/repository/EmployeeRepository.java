package com.example.springexampractice.repository;

import com.example.springexampractice.model.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    boolean existsById(Long id);
}
