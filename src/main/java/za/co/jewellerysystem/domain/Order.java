package za.co.jewellerysystem.domain;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
public class Order {

    @Id
    @GeneratedValue
    private UUID id;

    private LocalDateTime orderDate;
    private BigDecimal totalPrice;
    private String status;
    private LocalDate collectionDate;
    private LocalTime collectionTime;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    public Order() {}

    public Order(UUID id, LocalDateTime orderDate, BigDecimal totalPrice, String status,
                 LocalDate collectionDate, LocalTime collectionTime, Customer customer) {
        this.id = id;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
        this.status = status;
        this.collectionDate = collectionDate;
        this.collectionTime = collectionTime;
        this.customer = customer;
    }

    // ----------- Builder -----------
    public static class Builder {
        private UUID id;
        private LocalDateTime orderDate;
        private BigDecimal totalPrice;
        private String status;
        private LocalDate collectionDate;
        private LocalTime collectionTime;
        private Customer customer;

        public Builder id(UUID id) { this.id = id; return this; }
        public Builder orderDate(LocalDateTime orderDate) { this.orderDate = orderDate; return this; }
        public Builder totalPrice(BigDecimal totalPrice) { this.totalPrice = totalPrice; return this; }
        public Builder status(String status) { this.status = status; return this; }
        public Builder collectionDate(LocalDate collectionDate) { this.collectionDate = collectionDate; return this; }
        public Builder collectionTime(LocalTime collectionTime) { this.collectionTime = collectionTime; return this; }
        public Builder customer(Customer customer) { this.customer = customer; return this; }

        public Order build() {
            return new Order(id, orderDate, totalPrice, status, collectionDate, collectionTime, customer);
        }
    }

    public static Builder builder() { return new Builder(); }

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getCollectionDate() {
        return collectionDate;
    }

    public void setCollectionDate(LocalDate collectionDate) {
        this.collectionDate = collectionDate;
    }

    public LocalTime getCollectionTime() {
        return collectionTime;
    }

    public void setCollectionTime(LocalTime collectionTime) {
        this.collectionTime = collectionTime;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
