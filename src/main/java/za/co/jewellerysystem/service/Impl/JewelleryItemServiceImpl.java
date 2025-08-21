package za.co.jewellerysystem.service.Impl;

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
    public JewelleryItem save(JewelleryItem jewelleryItem) {
        return repository.save(jewelleryItem);
    }

    @Override
    public Optional<JewelleryItem> findById(UUID id) {
        return repository.findById(id);
    }

    @Override
    public List<JewelleryItem> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }
}
