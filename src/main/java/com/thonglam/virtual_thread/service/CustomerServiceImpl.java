// ==========================================================
// 4. SERVICE IMPLEMENTATION
// ==========================================================
package com.thonglam.virtual_thread.service;

import com.thonglam.virtual_thread.entity.Customer;
import com.thonglam.virtual_thread.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repo;

    public CustomerServiceImpl(CustomerRepository repo) {
        this.repo = repo;
    }

    @Override
    public Customer save(Customer customer) {
        return repo.save(customer);
    }

    @Override
    public Customer getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer Not Found"));
    }

    @Override
    public List<Customer> getAll() {
        return repo.findAll();
    }

    @Override
    public Customer update(Long id, Customer customer) {
        Customer existing = getById(id);

        existing.setName(customer.getName());
        existing.setEmail(customer.getEmail());
        existing.setGender(customer.getGender());
        existing.setRegion(customer.getRegion());

        return repo.save(existing);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}