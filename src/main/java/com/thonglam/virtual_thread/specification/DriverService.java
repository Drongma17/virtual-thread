package com.thonglam.virtual_thread.specification;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DriverService {
    private final DriverRepository repository;

    public Page<Driver> filterEmployees(String name, Integer age, Double salary, String department, Pageable pageable) {
        Specification<Driver> spec = Specification
            .where(DriverSpecifications.hasName(name))
            .and(DriverSpecifications.hasAge(age))
            .and(DriverSpecifications.hasSalaryGreaterThan(salary))
            .and(DriverSpecifications.hasDepartment(department));

        return repository.findAll(spec, pageable);
    }
}