package za.co.jewellerysystem.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JewelleryItem {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false)
    private UUID id;


    private String name;

    private String description;

    private Double price;

    @ManyToOne
    private Category category;

    public JewelleryItem orElse(Object o) {
        return null;
    }

    public JewelleryItem map(Object o) {
        return null;
    }
}
