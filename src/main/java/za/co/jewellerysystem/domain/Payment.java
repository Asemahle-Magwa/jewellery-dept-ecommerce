package za.co.jewellerysystem.domain;
// Payment.java


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false)
    private UUID id;

    @ManyToOne
    private Order order;

    private Double amount;

    private String method;

    private LocalDateTime paidAt;

    public void setOrder(Optional<Order> order) {
    }

    public void setOrder(Order order) {
    }
}
