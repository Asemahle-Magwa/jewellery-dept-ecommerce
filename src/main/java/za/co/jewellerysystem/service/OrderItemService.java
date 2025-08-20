package za.co.jewellerysystem.service;

import aj.org.objectweb.asm.commons.Remapper;
import za.co.jewellerysystem.domain.OrderItem;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderItemService {
    OrderItem create(OrderItem orderItem);
    Optional<OrderItem> read(UUID id);
    List<OrderItem> getAll();
    void delete(UUID id);

    OrderItem save(OrderItem orderItem);

    Remapper findById(UUID id);

    List<OrderItem> findAll();

    void deleteById(UUID id);
}
