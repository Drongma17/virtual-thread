package com.thonglam.virtual_thread.repository;


import com.thonglam.virtual_thread.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByRegion(String region);
}