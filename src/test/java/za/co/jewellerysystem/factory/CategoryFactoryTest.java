package za.co.jewellerysystem.factory;

import org.junit.jupiter.api.Test;
import za.co.jewellerysystem.domain.Category;

import static org.junit.jupiter.api.Assertions.*;

class CategoryFactoryTest {

    @Test
    void createCategory_success() {
        Category category = CategoryFactory.createCategory("Bracelets");

        assertNotNull(category);
        assertEquals("Bracelets", category.getName());
    }

    @Test
    void createCategory_blankName_shouldThrowException() {
        Exception ex = assertThrows(IllegalArgumentException.class, () ->
                CategoryFactory.createCategory("")
        );
        assertEquals("Invalid input data for Category creation.", ex.getMessage());
    }
}


