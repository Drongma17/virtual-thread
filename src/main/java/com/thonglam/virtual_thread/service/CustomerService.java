// ==========================================================
// 3. SERVICE
// ==========================================================
package com.thonglam.virtual_thread.service;


import com.thonglam.virtual_thread.entity.Customer;

import java.util.List;

public interface CustomerService {

    Customer save(Customer customer);

    Customer getById(Long id);

    List<Customer> getAll();

    Customer update(Long id, Customer customer);

    void delete(Long id);
}