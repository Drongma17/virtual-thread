package com.thonglam.virtual_thread;



import com.thonglam.virtual_thread.controller.EmployeeController;
import com.thonglam.virtual_thread.entity.Employee;
import com.thonglam.virtual_thread.service.EmployeeService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import java.util.Optional;

import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private EmployeeService service;

    @Test
    void testGetEmployeeById() throws Exception {

        Employee emp =
                new Employee(1L,"John","IT");

        when(service.getEmployeeById(1L))
                .thenReturn(Optional.of(emp));

        mockMvc.perform(get("/employees/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John"))
                .andExpect(jsonPath("$.department").value("IT"));
    }
}