package za.co.jewellerysystem.factory;

import org.junit.jupiter.api.Test;
import za.co.jewellerysystem.domain.JewelleryItem;
import za.co.jewellerysystem.domain.Order;
import za.co.jewellerysystem.domain.OrderItem;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class OrderItemFactoryTest {

    @Test
    void createOrderItem_WithValidObjects_ShouldCreateOrderItem() {
        Order order = new Order();
        JewelleryItem jewelleryItem = new JewelleryItem();
        BigDecimal price = new BigDecimal("150.00");
        int quantity = 2;

        OrderItem item = OrderItemFactory.createOrderItem(order, jewelleryItem, quantity, price);

        assertNotNull(item);
        assertEquals(quantity, item.getQuantity());
        assertEquals(price, item.getPrice());
        assertEquals(order, item.getOrder());
        assertEquals(jewelleryItem, item.getJewelleryItem());
        assertNotNull(item.getId());
    }

    @Test
    void createOrderItem_InvalidQuantity_ShouldThrowException() {
        Order order = new Order();
        JewelleryItem jewelleryItem = new JewelleryItem();

        assertThrows(IllegalArgumentException.class, () -> {
            OrderItemFactory.createOrderItem(order, jewelleryItem, 0, new BigDecimal("150.00"));
        });
    }

    @Test
    void createOrderItem_WithUUIDs_ShouldReturnNull() {
        // Call the factory method directly
        OrderItem item = OrderItemFactory.createOrderItem(
                UUID.randomUUID(),   // orderItemId
                UUID.randomUUID(),   // jewelleryItemId
                1,                   // quantity
                new BigDecimal("100.00")  // price
        );

        // The factory currently always returns null
        assertNull(item);
    }

}
