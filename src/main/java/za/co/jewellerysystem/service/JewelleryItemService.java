package za.co.jewellerysystem.service;

import aj.org.objectweb.asm.commons.Remapper;
import za.co.jewellerysystem.domain.JewelleryItem;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface JewelleryItemService {
    JewelleryItem create(JewelleryItem jewelleryItem);
    Optional<JewelleryItem> read(UUID id);
    JewelleryItem update(JewelleryItem jewelleryItem);
    void delete(UUID id);
    List<JewelleryItem> findAll();

    Remapper findById(UUID id);

    JewelleryItem save(JewelleryItem jewelleryItem);

    void deleteById(UUID id);
}
