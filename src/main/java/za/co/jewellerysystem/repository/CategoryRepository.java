package za.co.jewellerysystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.jewellerysystem.domain.Category;

import java.util.List;
import java.util.UUID;
@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {

    Category findByName(String name);

    List<Category> findByNameIgnoreCase(String name);

    List<Category> findByNameContainingIgnoreCase(String keyword);
}

