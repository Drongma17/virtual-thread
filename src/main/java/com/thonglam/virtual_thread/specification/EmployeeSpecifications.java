package com.thonglam.virtual_thread.specification;

import org.springframework.data.jpa.domain.Specification;

public class EmployeeSpecifications {

    public static Specification<Employee> hasName(String name) {
        return (root, query, cb) -> 
            (name == null || name.isEmpty()) ? null : cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%");
    }

    public static Specification<Employee> hasAge(Integer age) {
        return (root, query, cb) -> 
            age == null ? null : cb.equal(root.get("age"), age);
    }

    public static Specification<Employee> hasSalaryGreaterThan(Double salary) {
        return (root, query, cb) -> 
            salary == null ? null : cb.greaterThanOrEqualTo(root.get("salary"), salary);
    }

    public static Specification<Employee> hasDepartment(String dept) {
        return (root, query, cb) -> 
            (dept == null || dept.isEmpty()) ? null : cb.equal(root.get("department"), dept);
    }
}