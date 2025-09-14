package za.co.jewellerysystem.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.jewellerysystem.domain.Customer;
import za.co.jewellerysystem.domain.JewelleryItem;
import za.co.jewellerysystem.domain.Order;
import za.co.jewellerysystem.domain.OrderItem;
import za.co.jewellerysystem.repository.CustomerRepository;
import za.co.jewellerysystem.repository.JewelleryItemRepository;
import za.co.jewellerysystem.repository.OrderRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderRepository orderRepo;
    private final CustomerRepository customerRepo;
    private final JewelleryItemRepository itemRepo;

    public OrderController(OrderRepository orderRepo, CustomerRepository customerRepo, JewelleryItemRepository itemRepo) {
        this.orderRepo = orderRepo;
        this.customerRepo = customerRepo;
        this.itemRepo = itemRepo;
    }

    @GetMapping
    public List<Order> list(@RequestParam Map<String, String> params) {
        // ignoring params filtering for simplicity
        return orderRepo.findAll();
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Order> get(@PathVariable Long id) {
//        return orderRepo.findById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }

    @PostMapping
    public Order create(@RequestBody Order order) {
        order.setCreatedAt(LocalDateTime.now());
        if (order.getCustomer() != null && order.getCustomer().getId() != null) {
            Customer cust = customerRepo.findById(order.getCustomer().getId()).orElse(null);
            order.setCustomer(cust);
        }
        if (order.getItems() != null) {
            for (OrderItem oi : order.getItems()) {
                oi.setOrder(order);
                if (oi.getItem() != null && oi.getItem().getId() != null) {
                    JewelleryItem ji = itemRepo.findById(oi.getItem().getId()).orElse(null);
                    oi.setItem(ji);
                }
            }
        }
        return orderRepo.save(order);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Order> updateStatus(@PathVariable UUID id, @RequestBody Map<String, String> body) {
        return orderRepo.findById(id).map(order -> {
            order.setStatus(body.get("status"));
            orderRepo.save(order);
            return ResponseEntity.ok(order);
        }).orElse(ResponseEntity.notFound().build());
    }
}

