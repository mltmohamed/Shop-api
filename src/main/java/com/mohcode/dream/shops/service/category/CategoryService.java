package com.mohcode.dream.shops.service.category;

import com.mohcode.dream.shops.exceptions.AlreadyExistException;
import com.mohcode.dream.shops.exceptions.RessourceNotFoundException;
import com.mohcode.dream.shops.model.Category;
import com.mohcode.dream.shops.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService implements iCategoryService{
    private final CategoryRepository categoryRepository;
    @Override
    public Category getCategoryByid(long id) {
        return categoryRepository
                .findById(id)
                .orElseThrow(() -> new RessourceNotFoundException("category non trouvée avec l'id : " + id));
    }

    @Override
    public Category getCategoryByName(String name) {
        return categoryRepository
                .findByName(name);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository
                .findAll();
    }

    @Override
    public Category addCategory(Category category) {
        return Optional.of(category).filter(c -> !categoryRepository.existsByName(c.getName()))
                .map(categoryRepository::save)
                .orElseThrow(() -> new AlreadyExistException("category déjà existante avec le nom : " + category.getName()));
    }

    @Override
    public Category updateCategory(Category category, long id) {
        return Optional.ofNullable(getCategoryByid(id))
                .map(oldCategory -> {
                    oldCategory.setName(category.getName());
                    return categoryRepository.save(oldCategory);
                })
                .orElseThrow(() -> new RessourceNotFoundException("category non trouvée avec; l'id : " + id));

    }

    @Override
    public void deleteCategory(long id) {
        categoryRepository
                .findById(id)
                .ifPresentOrElse(categoryRepository::delete, () -> {
                    throw new RessourceNotFoundException("category non trouvée avec l'id : " + id);
                });

    }
}
