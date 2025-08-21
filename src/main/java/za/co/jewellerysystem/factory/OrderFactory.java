package za.co.jewellerysystem.factory;

import za.co.jewellerysystem.domain.Customer;
import za.co.jewellerysystem.domain.Order;
import za.co.jewellerysystem.domain.OrderItem;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

public class OrderFactory {

    public static Order createOrder(Customer customer,
                                    List<OrderItem> orderItems,
                                    BigDecimal totalPrice,
                                    String status,
                                    LocalDate collectionDate,
                                    LocalTime collectionTime) {

        if (customer == null) throw new IllegalArgumentException("Customer cannot be null");
        if (orderItems == null || orderItems.isEmpty())
            throw new IllegalArgumentException("Order must have at least one item");
        if (status == null || status.isBlank())
            throw new IllegalArgumentException("Order status cannot be empty");
        if (collectionDate == null || collectionTime == null)
            throw new IllegalArgumentException("Collection date and time are required");

        // If totalPrice not provided, compute from items: sum(price * quantity)
        if (totalPrice == null) {
            totalPrice = orderItems.stream()
                    .map(oi -> oi.getPrice().multiply(BigDecimal.valueOf(oi.getQuantity())))
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
        }

        Order order = new Order(
                UUID.randomUUID(),
                LocalDateTime.now(),
                totalPrice,
                status,
                collectionDate,
                collectionTime,
                customer
        );

        // Wire up bidirectional relationship
        for (OrderItem oi : orderItems) {
            oi.setOrder(order);
        }
        order.setOrderItems(orderItems);

        return order;
    }

    public static Order createOrder(UUID customerId, double totalAmount) {
        return null;
    }
}
