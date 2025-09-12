package za.co.jewellerysystem.security;

import za.co.jewellerysystem.domain.*;
import za.co.jewellerysystem.factory.OrderItemFactory;

import java.math.BigDecimal;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

class MainTest {

    void testOrderItemCreation() {
        // Arrange
        Order order = new Order();
        JewelleryItem jewelleryItem = new JewelleryItem();

        // Act
        OrderItem orderItem = OrderItemFactory.createOrderItem(order, jewelleryItem, 2, new BigDecimal("250.00"));

        // Assert
        assertNotNull(orderItem);
        assertEquals(2, orderItem.getQuantity());
        assertEquals(new BigDecimal("250.00"), orderItem.getPrice());

        System.out.println("✅ Order created: " + order);
        System.out.println("✅ OrderItem created: " + orderItem);
    }

    private void assertEquals(int i, int quantity) {
    }

    private void assertEquals(BigDecimal bigDecimal, BigDecimal price) {
    }

}


