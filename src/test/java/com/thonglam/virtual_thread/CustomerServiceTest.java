// ==========================================================
// SERVICE LAYER TEST
// ==========================================================
package com.thonglam.virtual_thread;


import com.thonglam.virtual_thread.entity.Customer;
import com.thonglam.virtual_thread.repository.CustomerRepository;
import com.thonglam.virtual_thread.service.CustomerServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CustomerServiceTest {

    @Mock
    private CustomerRepository repo;

    @InjectMocks
    private CustomerServiceImpl service;

    public CustomerServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getByIdTest() {

        Customer c = new Customer(1L,"John","john@gmail.com","Male","USA");

        when(repo.findById(1L)).thenReturn(Optional.of(c));

        Customer result = service.getById(1L);

        assertEquals("John", result.getName());
    }
}