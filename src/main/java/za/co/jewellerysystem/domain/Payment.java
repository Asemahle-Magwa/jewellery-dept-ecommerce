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
    private String method; // <-- added field

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public Payment() {}

    public Payment(UUID id, LocalDate paymentDate, BigDecimal amount, String status, String method, Order order) {
        this.id = id;
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.status = status;
        this.method = method;
        this.order = order;
    }

    // ----------- Builder -----------
    public static class Builder {
        private UUID id;
        private LocalDate paymentDate;
        private BigDecimal amount;
        private String status;
        private String method; // <-- added field
        private Order order;

        public Builder id(UUID id) { this.id = id; return this; }
        public Builder paymentDate(LocalDate paymentDate) { this.paymentDate = paymentDate; return this; }
        public Builder amount(BigDecimal amount) { this.amount = amount; return this; }
        public Builder status(String status) { this.status = status; return this; }
        public Builder method(String method) { this.method = method; return this; } // <-- added
        public Builder order(Order order) { this.order = order; return this; }

        public Payment build() {
            return new Payment(id, paymentDate, amount, status, method, order);
        }
    }

    public static Builder builder() { return new Builder(); }

    // ----------- Getters & Setters -----------
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public LocalDate getPaymentDate() { return paymentDate; }
    public void setPaymentDate(LocalDate paymentDate) { this.paymentDate = paymentDate; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getMethod() { return method; }
    public void setMethod(String method) { this.method = method; }

    public Order getOrder() { return order; }
    public void setOrder(Order order) { this.order = order; }
}
