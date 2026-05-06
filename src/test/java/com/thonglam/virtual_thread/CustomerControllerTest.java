// ==========================================================
// CONTROLLER TEST
// ==========================================================
package com.thonglam.virtual_thread;



import com.thonglam.virtual_thread.controller.CustomerController;
import com.thonglam.virtual_thread.entity.Customer;
import com.thonglam.virtual_thread.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CustomerController.class)
class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private CustomerService service;

    @Test
    void getCustomerByIdTest() throws Exception {

        Customer c = new Customer(1L,"John","john@gmail.com","Male","USA");

        Mockito.when(service.getById(1L)).thenReturn(c);

        mockMvc.perform(get("/customers/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John"));
    }
}