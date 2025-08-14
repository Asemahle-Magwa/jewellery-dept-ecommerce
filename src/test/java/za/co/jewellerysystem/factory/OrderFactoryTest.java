package za.co.jewellerysystem.factory;

import org.junit.jupiter.api.Test;
import za.co.jewellerysystem.domain.Customer;
import za.co.jewellerysystem.domain.Order;
import za.co.jewellerysystem.domain.OrderItem;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class OrderFactoryTest {

    @Test
    void createOrder_ValidInput_ShouldCreateOrder() {
        // Arrange
        Customer customer = new Customer(UUID.randomUUID(), "John", "Doe", "john@example.com", "123456789");
        OrderItem item1 = new OrderItem(UUID.randomUUID(), 2, new BigDecimal("100.00"));
        OrderItem item2 = new OrderItem(UUID.randomUUID(), 1, new BigDecimal("50.00"));

        List<OrderItem> items = List.of(item1, item2);

        // Act
        Order order = OrderFactory.createOrder(
                customer,
                items,
                null, // let factory calculate totalPrice
                "Pending",
                LocalDate.now(),
                LocalTime.now()
        );

        // Assert
        assertNotNull(order);
        assertEquals(customer, order.getCustomer());
        assertEquals(2, order.getOrderItems().size());
        assertEquals(new BigDecimal("250.00"), order.getTotalPrice());
        assertEquals("Pending", order.getStatus());
    }

    @Test
    void createOrder_NullCustomer_ShouldThrowException() {
        OrderItem item = new OrderItem(UUID.randomUUID(), 1, new BigDecimal("50.00"));

        assertThrows(IllegalArgumentException.class, () -> {
            OrderFactory.createOrder(
                    null,
                    List.of(item),
                    new BigDecimal("50.00"),
                    "Pending",
                    LocalDate.now(),
                    LocalTime.now()
            );
        });
    }
}
