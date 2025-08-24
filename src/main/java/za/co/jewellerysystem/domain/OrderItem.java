package za.co.jewellerysystem.domain;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue
    private UUID id;

    private int quantity;
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "jewellery_item_id")
    private JewelleryItem jewelleryItem;

    public OrderItem() {}

    public OrderItem(UUID id, int quantity, BigDecimal price, Order order, JewelleryItem jewelleryItem) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.order = order;
        this.jewelleryItem = jewelleryItem;
    }

    public OrderItem(UUID uuid, int i, BigDecimal bigDecimal) {

    }

    // ----------- Builder -----------
    public static class Builder {
        private UUID id;
        private int quantity;
        private BigDecimal price;
        private Order order;
        private JewelleryItem jewelleryItem;

        public Builder id(UUID id) { this.id = id; return this; }
        public Builder quantity(int quantity) { this.quantity = quantity; return this; }
        public Builder price(BigDecimal price) { this.price = price; return this; }
        public Builder order(Order order) { this.order = order; return this; }
        public Builder jewelleryItem(JewelleryItem jewelleryItem) { this.jewelleryItem = jewelleryItem; return this; }

        public OrderItem build() {
            return new OrderItem(id, quantity, price, order, jewelleryItem);
        }


    public static Builder builder() { return new Builder(); }

    // Getters & setters...
}


    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public JewelleryItem getJewelleryItem() {
        return jewelleryItem;
    }

    public void setJewelleryItem(JewelleryItem jewelleryItem) {
        this.jewelleryItem = jewelleryItem;
    }
}
