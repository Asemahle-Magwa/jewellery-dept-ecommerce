package za.co.jewellerysystem.factory;

import org.junit.jupiter.api.Test;
import za.co.jewellerysystem.domain.Category;
import za.co.jewellerysystem.domain.JewelleryItem;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class JewelleryItemFactoryTest {

    @Test
    void createJewelleryItem_success() {
        Category category = new Category(UUID.randomUUID(), "Rings");

        JewelleryItem item = JewelleryItemFactory.createJewelleryItem(
                "Diamond Ring",
                "Elegant gold ring with diamond",
                BigDecimal.valueOf(1500.00),
                5,
                category
        );

        assertNotNull(item);
        assertEquals("Diamond Ring", item.getName());
        assertEquals(BigDecimal.valueOf(1500.00), item.getPrice());
        assertEquals(category, item.getCategory());
    }

    @Test
    void createJewelleryItem_nullCategory_shouldThrowException() {
        Exception ex = assertThrows(IllegalArgumentException.class, () ->
                JewelleryItemFactory.createJewelleryItem(
                        "Diamond Ring",
                        "Elegant gold ring with diamond",
                        BigDecimal.valueOf(1500.00),
                        5,
                        null
                )
        );
        assertEquals("Invalid input data for JewelleryItem creation.", ex.getMessage());
    }
}
