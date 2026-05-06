package com.thonglam.virtual_thread.controller;


import com.thonglam.virtual_thread.entity.Employee;
import com.thonglam.virtual_thread.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Employee> save(@RequestBody Employee emp) {
        return new ResponseEntity<>(
                service.saveEmployee(emp),
                HttpStatus.CREATED);
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable Long id) {
        return service.getEmployeeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<Employee>> getAll() {
        return ResponseEntity.ok(service.getAllEmployees());
    }

    // READ BY DEPARTMENT
    @GetMapping("/department/{dept}")
    public ResponseEntity<List<Employee>> getByDept(@PathVariable String dept) {
        return ResponseEntity.ok(service.getEmployeesByDepartment(dept));
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(
            @PathVariable Long id,
            @RequestBody Employee emp) {

        return ResponseEntity.ok(service.updateEmployee(id, emp));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.deleteEmployee(id);
        return ResponseEntity.ok("Deleted Successfully");
    }
}