package za.co.jewellerysystem.factory;

import za.co.jewellerysystem.domain.JewelleryItem;
import za.co.jewellerysystem.domain.Order;
import za.co.jewellerysystem.domain.OrderItem;

import java.math.BigDecimal;
import java.util.UUID;

public class OrderItemFactory {

    public static OrderItem createOrderItem(Order order, JewelleryItem jewelleryItem, int quantity, BigDecimal price) {
        if (order == null || jewelleryItem == null || quantity <= 0 || price == null) {
            throw new IllegalArgumentException("Invalid input data for OrderItem creation.");
        }

        return new OrderItem(
                UUID.randomUUID(),
                quantity,
                price,
                order,
                jewelleryItem
        );
    }

    public static OrderItem createOrderItem(UUID uuid, UUID uuid1, int quantity, BigDecimal price) {
        return null;
    }
}
