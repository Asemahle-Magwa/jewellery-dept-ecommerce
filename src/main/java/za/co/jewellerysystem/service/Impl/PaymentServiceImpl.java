package za.co.jewellerysystem.service.Impl;

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
    public Payment save(Payment payment) {
        return repository.save(payment);
    }

    @Override
    public Optional<Payment> findById(UUID id) {
        return repository.findById(id);
    }

    @Override
    public List<Payment> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }
}
