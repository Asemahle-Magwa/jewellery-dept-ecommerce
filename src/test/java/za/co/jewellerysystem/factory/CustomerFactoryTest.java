package za.co.jewellerysystem.factory;

import org.junit.jupiter.api.Test;
import za.co.jewellerysystem.domain.Customer;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CustomerFactoryTest {

    @Test
    void createCustomer_success() {
        Customer customer = CustomerFactory.createCustomer(
                "hashedPassword123",
                "John Doe",
                "johndoe@email.com",
                "0723456789",
                "U12345"
        );

        assertNotNull(customer);
        assertNotNull(customer.getId());
        assertEquals("John Doe", customer.getFullName());
        assertEquals("johndoe@email.com", customer.getEmail());
    }

    @Test
    void createCustomer_nullFullName_shouldThrowException() {
        Exception ex = assertThrows(IllegalArgumentException.class, () ->
                CustomerFactory.createCustomer(
                        "hashedPassword123",
                        null,
                        "johndoe@email.com",
                        "0723456789",
                        "U12345"
                )
        );
        assertEquals("Full name is required", ex.getMessage());
    }
}
