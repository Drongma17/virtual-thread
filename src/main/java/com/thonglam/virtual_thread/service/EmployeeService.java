package com.thonglam.virtual_thread.service;


import com.thonglam.virtual_thread.entity.Employee;
import com.thonglam.virtual_thread.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // CREATE
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // READ BY ID
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    // READ ALL
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // FIND BY DEPARTMENT
    public List<Employee> getEmployeesByDepartment(String dept) {
        return employeeRepository.findByDepartment(dept);
    }

    // UPDATE
    public Employee updateEmployee(Long id, Employee employee) {

        Employee existing = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        existing.setName(employee.getName());
        existing.setDepartment(employee.getDepartment());

        return employeeRepository.save(existing);
    }

    // DELETE
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}