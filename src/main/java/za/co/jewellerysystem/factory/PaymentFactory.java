package za.co.jewellerysystem.factory;

import za.co.jewellerysystem.domain.Order;
import za.co.jewellerysystem.domain.Payment;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class PaymentFactory {

    public static Payment createPayment(Order order, BigDecimal amount, String status) {
        if (order == null || amount == null || status == null || status.isEmpty()) {
            throw new IllegalArgumentException("Invalid input data for Payment creation.");
        }

        return new Payment(
                UUID.randomUUID(),
                LocalDate.now(),
                amount,
                status,
                order
        );
    }
}
