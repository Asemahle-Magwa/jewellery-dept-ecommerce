package za.co.jewellerysystem.domain;

import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class Category {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    // Relationship with JewelleryItem (one category can have many jewellery items)
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<JewelleryItem> jewelleryItems;

    // Default constructor
    public Category() {}

    // All-args constructor (without jewelleryItems for builder)
    public Category(UUID id, String name) {
        this.id = id;
        this.name = name;
    }


    // ----------- Builder -----------
    public static class Builder {
        private UUID id;
        private String name;

        public Builder id(UUID id) { this.id = id; return this; }
        public Builder name(String name) { this.name = name; return this; }

        public Category build() {
            return new Category(id, name);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    // Getters and setters
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

    public List<JewelleryItem> getJewelleryItems() {
        return jewelleryItems;
    }

    public void setJewelleryItems(List<JewelleryItem> jewelleryItems) {
        this.jewelleryItems = jewelleryItems;
    }
}
