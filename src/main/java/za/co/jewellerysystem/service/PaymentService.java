package za.co.jewellerysystem.service;

import za.co.jewellerysystem.domain.Payment;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PaymentService {
    Payment save(Payment payment);                    // create/update
    Optional<Payment> findById(UUID id);              // read
    List<Payment> findAll();                          // list all
    void deleteById(UUID id);                         // delete
}
