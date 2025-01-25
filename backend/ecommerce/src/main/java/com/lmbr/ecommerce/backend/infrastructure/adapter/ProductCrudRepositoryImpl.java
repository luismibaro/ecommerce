package com.lmbr.ecommerce.backend.infrastructure.adapter;

import com.lmbr.ecommerce.backend.domain.model.Product;
import com.lmbr.ecommerce.backend.domain.port.IProductRepository;
import com.lmbr.ecommerce.backend.infrastructure.mapper.ProductMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * Implementation of the IProductRepository interface using Spring Data repositories.
 */
@Repository
//@AllArgsConstructor
public class ProductCrudRepositoryImpl implements IProductRepository {
    private final IProductCrudRepository iProductCrudRepository;
    private final ProductMapper productMapper;

    /**
     * Constructor for dependency injection.
     */
    public ProductCrudRepositoryImpl(IProductCrudRepository iProductCrudRepository, ProductMapper productMapper) {
        this.iProductCrudRepository = iProductCrudRepository;
        this.productMapper = productMapper;
    }

    @Override
    public Product save(Product product) {
        // Save the product after converting it to the entity and then back to the model.
        return productMapper.toProduct(iProductCrudRepository.save(productMapper.toProductEntity(product)));
    }

    @Override
    public Iterable<Product> findAll() {
        // Retrieve all products and map them to the domain model.
        return productMapper.toProductList(iProductCrudRepository.findAll());
    }

    @Override
    public Product findById(Integer id) {
        // Find a product by its ID and map it to the domain model, or throw an exception if not found.
        return productMapper.toProduct(iProductCrudRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Producto con id: " + id + " no se encuentra")
        ));
    }

    @Override
    public void deleteById(Integer id) {
        // Check if the product exists by its ID, then delete it if found, or throw an exception if not found.
        iProductCrudRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Producto con id: " + id + " no se encuentra")
        );
        iProductCrudRepository.deleteById(id);
    }
}
