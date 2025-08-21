package za.co.jewellerysystem.service;

import za.co.jewellerysystem.domain.Order;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderService {
    Order create(UUID customerId, double totalAmount);
    Order save(Order order);                          // create/update
    Optional<Order> findById(UUID id);                // read
    List<Order> findAll();                            // list all
    void deleteById(UUID id);                         // delete
}
