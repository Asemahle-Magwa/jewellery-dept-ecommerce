package za.co.jewellerysystem.factory;

import za.co.jewellerysystem.domain.Category;

import java.util.UUID;

public class CategoryFactory {

    public static Category createCategory(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Invalid input data for Category creation.");
        }

        return new Category(
                UUID.randomUUID(),
                name
        );
    }
}
