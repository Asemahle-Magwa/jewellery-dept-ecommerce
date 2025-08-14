package za.co.jewellerysystem.domain;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Payment {

    @Id
    @GeneratedValue
    private UUID id;

    private LocalDate paymentDate;
    private BigDecimal amount;
    private String status;

    // Relationship with Order (one payment belongs to one order)
    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    // Constructors
    public Payment() {}

    public Payment(UUID id, LocalDate paymentDate, BigDecimal amount, String status, Order order) {
        this.id = id;
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.status = status;
        this.order = order;
    }

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getPaymentMethod() {
        return null;
    }
}
