package za.co.jewellerysystem.service.Impl;

import org.springframework.stereotype.Service;
import za.co.jewellerysystem.domain.Customer;
import za.co.jewellerysystem.factory.CustomerFactory;
import za.co.jewellerysystem.repository.CustomerRepository;
import za.co.jewellerysystem.service.CustomerService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Customer create(String passwordHash, String fullName, String email, String phone, String universityId) {
        // ✅ Use your factory to build a valid Customer
        Customer customer = CustomerFactory.createCustomer(passwordHash, fullName, email, phone, universityId);
        return repository.save(customer);
    }

    @Override
    public Optional<Customer> findById(UUID id) {
        return repository.findById(id);
    }

    @Override
    public List<Customer> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public Customer save(Customer customer) {
        return null;
    }

    @Override
    public void deleteById(UUID id) {

    }
}
