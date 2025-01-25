package com.lmbr.ecommerce.backend.infrastructure.adapter;

import com.lmbr.ecommerce.backend.infrastructure.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * This interface defines CRUD operations for the ProductEntity entity.
 */
public interface IProductCrudRepository extends CrudRepository<ProductEntity, Integer> {
}
