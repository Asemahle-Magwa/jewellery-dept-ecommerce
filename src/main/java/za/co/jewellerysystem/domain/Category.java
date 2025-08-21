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

    // Constructors
    public Category() {}

    public Category(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

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

    public List<JewelleryItem> getJewelleryItems() {
        return jewelleryItems;
    }

    public void setJewelleryItems(List<JewelleryItem> jewelleryItems) {
        this.jewelleryItems = jewelleryItems;
    }

    public void setDescription(String goldAndDiamondRings) {

    }
}
