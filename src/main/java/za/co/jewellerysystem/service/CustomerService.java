package za.co.jewellerysystem.service;

import za.co.jewellerysystem.domain.Customer;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerService {
    Customer create(String passwordHash, String fullName, String email, String phone, String universityId);
    Optional<Customer> findById(UUID id);
    List<Customer> findAll();
    void delete(UUID id);

    Customer save(Customer customer);

    void deleteById(UUID id);
}
