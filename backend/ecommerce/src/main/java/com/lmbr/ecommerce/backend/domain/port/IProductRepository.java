package com.lmbr.ecommerce.backend.domain.port;

import com.lmbr.ecommerce.backend.domain.model.Product;

// Interface defining methods for interacting with the product repository
public interface IProductRepository {

    // Method to save a product in the repository
    Product save(Product product);

    // Method to find all products in the repository
    Iterable<Product> findAll();

    // Method to find a product by its ID in the repository
    Product findById(Integer id);

    // Method to delete a product by its ID from the repository
    void deleteById(Integer id);
}
