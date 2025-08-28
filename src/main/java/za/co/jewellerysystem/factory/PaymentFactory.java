package za.co.jewellerysystem.factory;

import za.co.jewellerysystem.domain.Order;
import za.co.jewellerysystem.domain.Payment;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class PaymentFactory {

    public static Payment createPayment(Order order, BigDecimal amount, String status, String method) {
        if (order == null || amount == null || status == null || status.isEmpty() || method == null || method.isEmpty()) {
            throw new IllegalArgumentException("Order, amount, status, and method are required");
        }

        return new Payment(
                UUID.randomUUID(),
                LocalDate.now(),
                amount,
                status,
                method, // <-- added
                order
        );
    }
}
