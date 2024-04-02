package com.example.springexampractice.service;

import com.example.springexampractice.model.Employee;
import com.example.springexampractice.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public List<Employee> findAll(String sortBy, String sortDirection, int page, int size) {
        Sort sort = sortBy.isEmpty() ? Sort.unsorted() : Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        if (page == -1 && size == -1) {
            return employeeRepository.findAll();
        }
        Pageable pageable = PageRequest.of(page, size, sort);

        return employeeRepository.findAll(pageable).stream().toList();
    }

    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Gay")
        );
    }

    public Employee add(Employee employee) {
        if (employee.getId() == null) {
            throw new RuntimeException("No id");
        }
        if (employeeRepository.existsById(employee.getId())) {
            throw new RuntimeException("This employee is already exists");
        }
        return employeeRepository.save(employee);
    }

    public Employee update(Employee employee, Long id) {
        if (!Objects.equals(employee.getId(), id)) {
            throw new RuntimeException("Employee id doesn't match");
        }
        if (employeeRepository.existsById(id)) {
            throw new RuntimeException("This employee is already exists");
        }
        return employeeRepository.save(employee);
    }

    public void delete(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new RuntimeException("Employee not found");
        }
        employeeRepository.deleteById(id);
    }


}
