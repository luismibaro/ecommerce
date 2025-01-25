package com.lmbr.ecommerce.backend.application;

import com.lmbr.ecommerce.backend.domain.model.Category;
import com.lmbr.ecommerce.backend.domain.port.ICategoryRepository;

// Service class responsible for handling business logic related to categories
public class CategoryService {

    // Injects an instance of ICategoryRepository to interact with the persistence layer
    private final ICategoryRepository iCategoryRepository;

    // Constructor that initializes the instance of ICategoryRepository
    public CategoryService(ICategoryRepository iCategoryRepository) {
        this.iCategoryRepository = iCategoryRepository;
    }

    // Method to save a category in the database
    public Category save(Category category) {
        return iCategoryRepository.save(category);
    }

    // Method to find all categories in the database
    public Iterable<Category> findAll() {
        return iCategoryRepository.findAll();
    }

    // Method to find a category by its ID in the database
    public Category findById(Integer id) {
        return iCategoryRepository.findById(id);
    }

    // Method to delete a category by its ID in the database
    public void deleteById(Integer id) {
        iCategoryRepository.deleteById(id);
    }
}
