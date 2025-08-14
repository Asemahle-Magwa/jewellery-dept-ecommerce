package za.co.jewellerysystem.util;

import za.co.jewellerysystem.domain.*;
import za.co.jewellerysystem.factory.OrderItemFactory;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        // Create domain objects
        Order order = new Order();
        JewelleryItem jewelleryItem = new JewelleryItem();

        // Use factory to create an OrderItem
        OrderItem orderItem = OrderItemFactory.createOrderItem(order, jewelleryItem, 2, new BigDecimal("250.00"));

        System.out.println("Order created: " + order);
        System.out.println("OrderItem created: " + orderItem);
    }
}
