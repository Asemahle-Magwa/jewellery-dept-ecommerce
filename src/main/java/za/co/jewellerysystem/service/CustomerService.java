package za.co.jewellerysystem.service;

import za.co.jewellerysystem.domain.Customer;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerService {
    Customer create(String passwordHash, String fullName, String email, String phone, String universityId);
    Customer save(Customer customer);                 // create/update
    Optional<Customer> findById(UUID id);             // read
    List<Customer> findAll();                         // list all
    void deleteById(UUID id);                         // delete
}
