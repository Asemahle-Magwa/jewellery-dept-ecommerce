package za.co.jewellerysystem.factory;

import za.co.jewellerysystem.domain.Category;
import za.co.jewellerysystem.domain.JewelleryItem;

import java.math.BigDecimal;
import java.util.UUID;

public class JewelleryItemFactory {

    public static JewelleryItem createJewelleryItem(String name, String description, BigDecimal price, int quantity, Category category) {
        if (name == null || name.isEmpty() || description == null || description.isEmpty()
                || price == null || price.compareTo(BigDecimal.ZERO) <= 0 || quantity < 0 || category == null) {
            throw new IllegalArgumentException("Invalid input data for JewelleryItem creation.");
        }

        return new JewelleryItem(
                UUID.randomUUID(),
                name,
                description,
                price,
                quantity,
                category
        );
    }
}
