package za.co.jewellerysystem.service;

import za.co.jewellerysystem.domain.JewelleryItem;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface JewelleryItemService {
    JewelleryItem save(JewelleryItem jewelleryItem);      // create or update
    Optional<JewelleryItem> findById(UUID id);             // read
    List<JewelleryItem> findAll();                         // list all
    void deleteById(UUID id);                              // delete
}
