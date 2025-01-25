package com.lmbr.ecommerce.backend.infrastructure.mapper;

import com.lmbr.ecommerce.backend.domain.model.Product;
import com.lmbr.ecommerce.backend.infrastructure.entity.ProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * Mapper interface for converting between Product and ProductEntity objects.
 */
@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mappings(
            {
                    @Mapping(source = "id", target = "id"),
                    @Mapping(source = "name", target = "name"),
                    @Mapping(source = "code", target = "code"),
                    @Mapping(source = "description", target = "description"),
                    @Mapping(source = "urlImage", target = "urlImage"),
                    @Mapping(source = "price", target = "price"),
                    @Mapping(source = "dateCreated", target = "dateCreated"),
                    @Mapping(source = "dateUpdated", target = "dateUpdated"),
                    @Mapping(source = "userEntity.id", target = "userId"),
                    @Mapping(source = "categoryEntity.id", target = "categoryId")
            }
    )
        // Converts ProductEntity to Product
    Product toProduct(ProductEntity productEntity);

    // Converts Iterable of ProductEntity to Iterable of Product
    Iterable<Product> toProductList(Iterable<ProductEntity> productEntities);

    @InheritInverseConfiguration
        // Converts Product to ProductEntity (inverting the mappings)
    ProductEntity toProductEntity(Product product);
}
