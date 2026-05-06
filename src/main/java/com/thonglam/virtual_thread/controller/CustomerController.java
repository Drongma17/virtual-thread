// ==========================================================
// 5. CONTROLLER
// ==========================================================
package com.thonglam.virtual_thread.controller;


import com.thonglam.virtual_thread.entity.Customer;
import com.thonglam.virtual_thread.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Customer> save(@RequestBody Customer customer) {
        return new ResponseEntity<>(service.save(customer), HttpStatus.CREATED);
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<Customer>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Customer> update(@PathVariable Long id,
                                           @RequestBody Customer customer) {
        return ResponseEntity.ok(service.update(id, customer));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deleted");
    }
}