package za.co.jewellerysystem.factory;

import za.co.jewellerysystem.domain.Customer;
import java.util.UUID;

public class CustomerFactory {

    public static Customer createCustomer(String passwordHash, String fullName, String email, String phone, String universityId) {
        if (passwordHash == null || passwordHash.isEmpty()
                || fullName == null || fullName.isEmpty()
                || email == null || email.isEmpty()
                || phone == null || phone.isEmpty()
                || universityId == null || universityId.isEmpty()) {
            throw new IllegalArgumentException("Invalid input data for Customer creation.");
        }

        return new Customer(
                UUID.randomUUID(),
                passwordHash,
                fullName,
                email,
                phone,
                universityId
        );
    }
}
