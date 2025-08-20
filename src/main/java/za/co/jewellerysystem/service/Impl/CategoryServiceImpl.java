package za.co.jewellerysystem.service.Impl;

import aj.org.objectweb.asm.commons.Remapper;
import org.springframework.stereotype.Service;
import za.co.jewellerysystem.domain.Category;
import za.co.jewellerysystem.repository.CategoryRepository;
import za.co.jewellerysystem.service.CategoryService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Category create(Category category) {
        return repository.save(category);
    }

    @Override
    public Optional<Category> read(UUID id) {
        return repository.findById(id);
    }

    @Override
    public Category update(Category category) {
        if (repository.existsById(category.getId())) {
            return repository.save(category);
        }
        throw new IllegalArgumentException("Category not found for update");
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public List<Category> findAll() {
        return repository.findAll();
    }

    @Override
    public Category save(Category category) {
        return null;
    }

    @Override
    public Remapper findById(UUID id) {
        return null;
    }

    @Override
    public void deleteById(UUID id) {

    }
}
