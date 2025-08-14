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

    // Relationship with Order (many order items belong to one order)
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    // Relationship with JewelleryItem (many order items can refer to one jewellery item)
    @ManyToOne
    @JoinColumn(name = "jewellery_item_id")
    private JewelleryItem jewelleryItem;

    // Constructors
    public OrderItem() {}

    public OrderItem(UUID id, int quantity, BigDecimal price, Order order, JewelleryItem jewelleryItem) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.order = order;
        this.jewelleryItem = jewelleryItem;
    }

    public OrderItem(UUID uuid, UUID uuid1, int quantity, BigDecimal price) {
    }

    public OrderItem(UUID uuid, int i, BigDecimal bigDecimal) {

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
