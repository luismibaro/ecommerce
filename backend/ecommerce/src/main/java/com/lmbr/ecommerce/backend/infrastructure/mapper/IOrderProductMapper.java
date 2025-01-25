package com.lmbr.ecommerce.backend.infrastructure.mapper; // Package declaration

import com.lmbr.ecommerce.backend.domain.model.OrderProduct; // Importing OrderProduct domain model
import com.lmbr.ecommerce.backend.infrastructure.entity.OrderProductEntity; // Importing OrderProductEntity entity model
import org.mapstruct.InheritInverseConfiguration; // Importing MapStruct annotation for inheriting inverse mapping configuration
import org.mapstruct.Mapper; // Importing MapStruct annotation for defining mapper
import org.mapstruct.Mapping; // Importing MapStruct annotation for defining mapping
import org.mapstruct.Mappings; // Importing MapStruct annotation for defining multiple mappings

@Mapper(componentModel = "spring") // Annotation to mark this interface as a Spring component for mapping
public interface IOrderProductMapper { // Declaration of interface

    @Mappings( // Annotation for defining multiple mappings
            {
                    @Mapping(source = "id", target = "id"), // Mapping source id to target id
                    @Mapping(source = "quantity", target = "quantity"), // Mapping source quantity to target quantity
                    @Mapping(source = "price", target = "price"), // Mapping source price to target price
                    @Mapping(source = "productId", target = "productId") // Mapping source productId to target productId
            }
    )
    OrderProduct toOrderProduct(OrderProductEntity orderProductEntity); // Method for converting OrderProductEntity to OrderProduct
    Iterable<OrderProduct> toOrderProductList(Iterable<OrderProductEntity> orderProductEntities); // Method for converting list of OrderProductEntity to list of OrderProduct

    @InheritInverseConfiguration // Annotation to inherit inverse mapping configuration
    OrderProductEntity toOrderProductEntity(OrderProduct orderProduct); // Method for converting OrderProduct to OrderProductEntity
}
