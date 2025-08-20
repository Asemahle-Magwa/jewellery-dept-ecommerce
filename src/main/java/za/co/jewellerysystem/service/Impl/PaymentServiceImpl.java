package za.co.jewellerysystem.service.Impl;

import aj.org.objectweb.asm.commons.Remapper;
import org.springframework.stereotype.Service;
import za.co.jewellerysystem.domain.Payment;
import za.co.jewellerysystem.repository.PaymentRepository;
import za.co.jewellerysystem.service.PaymentService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository repository;

    public PaymentServiceImpl(PaymentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Payment create(Payment payment) {
        return repository.save(payment);
    }

    @Override
    public Optional<Payment> read(UUID id) {
        return repository.findById(id);
    }

    @Override
    public Payment update(Payment payment) {
        if (repository.existsById(payment.getId())) {
            return repository.save(payment);
        }
        throw new IllegalArgumentException("Payment not found for update");
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public List<Payment> findAll() {
        return repository.findAll();
    }

    @Override
    public Payment save(Payment payment) {
        return null;
    }

    @Override
    public Remapper findById(UUID id) {
        return null;
    }

    @Override
    public void deleteById(UUID id) {

    }
}
