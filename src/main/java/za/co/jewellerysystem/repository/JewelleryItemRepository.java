package za.co.jewellerysystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.jewellerysystem.domain.JewelleryItem;

import java.util.UUID;

@Repository
public interface JewelleryItemRepository extends JpaRepository<JewelleryItem, UUID> {
    // Example custom finder
    JewelleryItem findByName(String name);
}
