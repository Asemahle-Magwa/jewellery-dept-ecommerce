package za.co.jewellerysystem.controller;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.jewellerysystem.domain.Category;
import za.co.jewellerysystem.domain.JewelleryItem;
import za.co.jewellerysystem.repository.CategoryRepository;
import za.co.jewellerysystem.repository.JewelleryItemRepository;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/jewellery-items")
public class JewelleryItemController {

    private final JewelleryItemRepository itemRepo;
    private final CategoryRepository categoryRepo;

    public JewelleryItemController(JewelleryItemRepository itemRepo, CategoryRepository categoryRepo) {
        this.itemRepo = itemRepo;
        this.categoryRepo = categoryRepo;
    }

    @GetMapping
    public List<JewelleryItem> list(@RequestParam Map<String, String> params) {
        // For simplicity, ignoring params filtering
        return itemRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<JewelleryItem> get(@PathVariable UUID id) {
        return itemRepo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public JewelleryItem create(@RequestBody JewelleryItem dto) {
        if (dto.getCategory() != null && dto.getCategory().getId() != null) {
            Category cat = categoryRepo.findById(dto.getCategory().getId()).orElse(null);
            dto.setCategory(cat);
        }
        return itemRepo.save(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JewelleryItem> update(@PathVariable UUID id, @RequestBody JewelleryItem dto) {
        return itemRepo.findById(id).map(item -> {
            item.setName(dto.getName());
            item.setDescription(dto.getDescription());
            item.setPrice(dto.getPrice());
            if (dto.getCategory() != null && dto.getCategory().getId() != null) {
                Category cat = categoryRepo.findById(dto.getCategory().getId()).orElse(null);
                item.setCategory(cat);
            } else {
                item.setCategory(null);
            }
            itemRepo.save(item);
            return ResponseEntity.ok(item);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remove(@PathVariable UUID id) {
        if (!itemRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        itemRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
