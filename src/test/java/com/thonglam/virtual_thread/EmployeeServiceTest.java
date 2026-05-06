package com.thonglam.virtual_thread;


import com.thonglam.virtual_thread.entity.Employee;
import com.thonglam.virtual_thread.repository.EmployeeRepository;
import com.thonglam.virtual_thread.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveEmployee() {

        Employee emp = new Employee(null,"Jane Doe","Finance");

        when(employeeRepository.save(emp)).thenReturn(emp);

        Employee saved = employeeService.saveEmployee(emp);

        assertEquals("Jane Doe", saved.getName());
        verify(employeeRepository, times(1)).save(emp);
    }

    @Test
    public void testGetEmployeeById() {

        Employee emp = new Employee(1L,"John Smith","IT");

        when(employeeRepository.findById(1L))
                .thenReturn(Optional.of(emp));

        Optional<Employee> found =
                employeeService.getEmployeeById(1L);

        assertTrue(found.isPresent());
        assertEquals("John Smith", found.get().getName());
    }

    @Test
    public void testGetEmployeesByDepartment() {

        Employee e1 = new Employee(1L,"Alice","HR");
        Employee e2 = new Employee(2L,"Bob","HR");

        when(employeeRepository.findByDepartment("HR"))
                .thenReturn(List.of(e1,e2));

        List<Employee> result =
                employeeService.getEmployeesByDepartment("HR");

        assertEquals(2, result.size());
    }

    @Test
    public void testDeleteEmployee() {

        employeeService.deleteEmployee(1L);

        verify(employeeRepository, times(1))
                .deleteById(1L);
    }
}