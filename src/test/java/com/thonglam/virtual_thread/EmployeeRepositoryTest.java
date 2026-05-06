package com.thonglam.virtual_thread;



import com.thonglam.virtual_thread.entity.Employee;
import com.thonglam.virtual_thread.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository repo;

    @Test
    void testFindByDepartment() {

        repo.save(new Employee(null,"Alice","HR"));
        repo.save(new Employee(null,"Bob","HR"));

        List<Employee> list = repo.findByDepartment("HR");

        assertEquals(2, list.size());
    }
}