package za.co.jewellerysystem.service.Impl;

import org.springframework.stereotype.Service;
import za.co.jewellerysystem.domain.Order;
import za.co.jewellerysystem.factory.OrderFactory;
import za.co.jewellerysystem.repository.OrderRepository;
import za.co.jewellerysystem.service.OrderService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;

    public OrderServiceImpl(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public Order create(UUID customerId, double totalAmount) {
        Order order = OrderFactory.createOrder(customerId, totalAmount);
        return repository.save(order);
    }

    @Override
    public Optional<Order> findById(UUID id) {
        return repository.findById(id);
    }

    @Override
    public List<Order> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public Order save(Order order) {
        return null;
    }

    @Override
    public void deleteById(UUID id) {

    }
}
