package com.thonglam.virtual_thread.specification;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository repository;

    public Page<Employee> filterEmployees(String name, Integer age, Double salary, String department, Pageable pageable) {
        Specification<Employee> spec = Specification
            .where(EmployeeSpecifications.hasName(name))
            .and(EmployeeSpecifications.hasAge(age))
            .and(EmployeeSpecifications.hasSalaryGreaterThan(salary))
            .and(EmployeeSpecifications.hasDepartment(department));

        return repository.findAll(spec, pageable);
    }
}