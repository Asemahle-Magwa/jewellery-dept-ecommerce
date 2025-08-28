package za.co.jewellerysystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.jewellerysystem.domain.JewelleryItem;
import za.co.jewellerysystem.domain.Order;
import za.co.jewellerysystem.domain.OrderItem;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, UUID> {
    List<OrderItem> findByOrder(Order order);
    List<OrderItem> findByJewelleryItem(JewelleryItem jewelleryItem);
}


