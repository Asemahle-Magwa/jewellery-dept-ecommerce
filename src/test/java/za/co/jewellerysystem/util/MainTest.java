package za.co.jewellerysystem.util;

import org.junit.jupiter.api.Test;
import za.co.jewellerysystem.domain.*;
import za.co.jewellerysystem.factory.OrderItemFactory;

import java.math.BigDecimal;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

class MainTest {

    @Test
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

}
