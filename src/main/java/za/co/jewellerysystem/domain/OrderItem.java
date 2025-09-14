package za.co.jewellerysystem.domain;
// OrderItem.java


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItem {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false)
    private UUID id;


        @ManyToOne
        private Order order;

        @ManyToOne
        private JewelleryItem item;  // <-- field name is 'item'

        private int quantity;

        // getters and setters
    }
