package za.co.jewellerysystem.service.Impl;

import aj.org.objectweb.asm.commons.Remapper;
import org.springframework.stereotype.Service;
import za.co.jewellerysystem.domain.JewelleryItem;
import za.co.jewellerysystem.repository.JewelleryItemRepository;
import za.co.jewellerysystem.service.JewelleryItemService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class JewelleryItemServiceImpl implements JewelleryItemService {

    private final JewelleryItemRepository repository;

    public JewelleryItemServiceImpl(JewelleryItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public JewelleryItem create(JewelleryItem jewelleryItem) {
        return repository.save(jewelleryItem);
    }

    @Override
    public Optional<JewelleryItem> read(UUID id) {
        return repository.findById(id);
    }

    @Override
    public JewelleryItem update(JewelleryItem jewelleryItem) {
        if (repository.existsById(jewelleryItem.getId())) {
            return repository.save(jewelleryItem);
        }
        throw new IllegalArgumentException("JewelleryItem not found for update");
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public List<JewelleryItem> findAll() {
        return repository.findAll();
    }

    @Override
    public Remapper findById(UUID id) {
        return null;
    }

    @Override
    public JewelleryItem save(JewelleryItem jewelleryItem) {
        return null;
    }

    @Override
    public void deleteById(UUID id) {

    }
}
