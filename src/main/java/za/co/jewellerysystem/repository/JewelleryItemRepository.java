package za.co.jewellerysystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.jewellerysystem.domain.JewelleryItem;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
@Repository
public interface JewelleryItemRepository extends JpaRepository<JewelleryItem, UUID> {

    JewelleryItem findByName(String name);

    List<JewelleryItem> findByCategoryId(UUID categoryId);

    List<JewelleryItem> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);

    List<JewelleryItem> findByStockGreaterThan(int stock);

    List<JewelleryItem> findByNameContainingIgnoreCase(String keyword);
}

