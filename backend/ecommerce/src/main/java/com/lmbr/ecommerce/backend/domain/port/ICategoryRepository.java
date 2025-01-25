package com.lmbr.ecommerce.backend.domain.port;

import com.lmbr.ecommerce.backend.domain.model.Category;

// Interface defining methods for interacting with the category repository
public interface ICategoryRepository {

    // Method to save a category in the repository
    Category save(Category category);

    // Method to find all categories in the repository
    Iterable<Category> findAll();

    // Method to find a category by its ID in the repository
    Category findById(Integer id);

    // Method to delete a category by its ID from the repository
    void deleteById(Integer id);
}
