package za.co.jewellerysystem.factory;

import org.junit.jupiter.api.Test;
import za.co.jewellerysystem.domain.Order;
import za.co.jewellerysystem.domain.Payment;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class PaymentFactoryTest {

    @Test
    void createPayment_success() {
        Order order = new Order(
                UUID.randomUUID(),
                LocalDateTime.now(),
                BigDecimal.valueOf(500.00),
                "Pending",
                null,
                null,
                null
        );

        Payment payment = PaymentFactory.createPayment(
                order,
                BigDecimal.valueOf(500.00),
                "PAID",          // status
                "CREDIT_CARD"    // method
        );

        assertNotNull(payment);
        assertEquals(BigDecimal.valueOf(500.00), payment.getAmount());
        assertEquals("PAID", payment.getStatus());
        assertEquals("CREDIT_CARD", payment.getMethod());
        assertNotNull(payment.getId());
        assertNotNull(payment.getPaymentDate());
        assertEquals(order, payment.getOrder());
    }

    @Test
    void createPayment_nullOrder_shouldThrowException() {
        Exception ex = assertThrows(IllegalArgumentException.class, () ->
                PaymentFactory.createPayment(
                        null,
                        BigDecimal.valueOf(500.00),
                        "PAID",
                        "CREDIT_CARD"
                )
        );
        assertEquals("Order, amount, status, and method are required", ex.getMessage());
    }
}
