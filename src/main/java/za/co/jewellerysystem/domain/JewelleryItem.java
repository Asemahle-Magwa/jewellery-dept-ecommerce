package za.co.jewellerysystem.domain;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
public class JewelleryItem {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private String description;
    private BigDecimal price;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "jewelleryItem", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    public JewelleryItem() {}

    public JewelleryItem(UUID id, String name, String description, BigDecimal price, int quantity, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    // ----------- Builder -----------
    public static class Builder {
        private UUID id;
        private String name;
        private String description;
        private BigDecimal price;
        private int quantity;
        private Category category;

        public Builder id(UUID id) { this.id = id; return this; }
        public Builder name(String name) { this.name = name; return this; }
        public Builder description(String description) { this.description = description; return this; }
        public Builder price(BigDecimal price) { this.price = price; return this; }
        public Builder quantity(int quantity) { this.quantity = quantity; return this; }
        public Builder category(Category category) { this.category = category; return this; }

        public JewelleryItem build() {
            return new JewelleryItem(id, name, description, price, quantity, category);
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
