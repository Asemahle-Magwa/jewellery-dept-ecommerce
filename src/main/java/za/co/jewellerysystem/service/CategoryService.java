package za.co.jewellerysystem.service;

import za.co.jewellerysystem.domain.Category;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoryService {
    Category save(Category category);                 // create/update
    Optional<Category> findById(UUID id);             // read
    List<Category> findAll();                         // list all
    void deleteById(UUID id);                         // delete
}
