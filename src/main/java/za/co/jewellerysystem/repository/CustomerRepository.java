package za.co.jewellerysystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.jewellerysystem.domain.Customer;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {


    Customer findByEmail(String email);

    List<Customer> findByLastName(String lastName);

    List<Customer> findByFirstNameIgnoreCaseOrLastNameIgnoreCase(String firstName, String lastName);

    List<Customer> findByCreatedAtAfter(LocalDate date);
}

