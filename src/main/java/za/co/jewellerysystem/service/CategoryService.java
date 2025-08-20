package za.co.jewellerysystem.service;

import aj.org.objectweb.asm.commons.Remapper;
import za.co.jewellerysystem.domain.Category;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoryService {
    Category create(Category category);
    Optional<Category> read(UUID id);
    Category update(Category category);
    void delete(UUID id);
    List<Category> findAll();

    Category save(Category category);

    Remapper findById(UUID id);

    void deleteById(UUID id);
}
