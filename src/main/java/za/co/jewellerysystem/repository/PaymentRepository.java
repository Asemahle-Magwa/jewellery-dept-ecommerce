package za.co.jewellerysystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.jewellerysystem.domain.Order;
import za.co.jewellerysystem.domain.Payment;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, UUID> {
    List<Payment> findByOrder(Order order);
    List<Payment> findByPaymentDate(LocalDate paymentDate);
}

