package za.co.jewellerysystem.service;

import aj.org.objectweb.asm.commons.Remapper;
import za.co.jewellerysystem.domain.Payment;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PaymentService {
    Payment create(Payment payment);
    Optional<Payment> read(UUID id);
    Payment update(Payment payment);
    void delete(UUID id);
    List<Payment> findAll();

    Payment save(Payment payment);

    Remapper findById(UUID id);

    void deleteById(UUID id);
}
