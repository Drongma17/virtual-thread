// ==========================================================
// DAO LAYER TEST
// ==========================================================
package com.thonglam.virtual_thread;


import com.thonglam.virtual_thread.entity.Customer;
import com.thonglam.virtual_thread.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;


import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository repo;

    @Test
    void saveCustomerTest() {
        Customer c = new Customer(1L,"John","john@gmail.com","Male","USA");

        Customer saved = repo.save(c);

        assertNotNull(saved);
        assertEquals("John", saved.getName());
    }
}