package com.lmbr.ecommerce.backend.infrastructure.mapper; // Package declaration

import com.lmbr.ecommerce.backend.domain.model.Order; // Importing Order domain model
import com.lmbr.ecommerce.backend.infrastructure.entity.OrderEntity; // Importing OrderEntity entity model
import com.lmbr.ecommerce.backend.infrastructure.entity.OrderProductEntity; // Importing OrderProductEntity entity model
import org.mapstruct.InheritInverseConfiguration; // Importing MapStruct annotation for inheriting inverse mapping configuration
import org.mapstruct.Mapper; // Importing MapStruct annotation for defining mapper
import org.mapstruct.Mapping; // Importing MapStruct annotation for defining mapping
import org.mapstruct.Mappings; // Importing MapStruct annotation for defining multiple mappings

@Mapper(componentModel = "spring", uses = {IOrderProductMapper.class}) // Annotation to mark this interface as a Spring component for mapping and specifying other mappers to be used
public interface IOrderMapper { // Declaration of interface

    @Mappings( // Annotation for defining multiple mappings
            {
                    @Mapping(source = "id", target = "id"), // Mapping source id to target id
                    @Mapping(source = "dateCreated", target = "dateCreated"), // Mapping source dateCreated to target dateCreated
                    @Mapping(source = "orderProducts", target = "orderProducts"), // Mapping source orderProducts to target orderProducts
                    @Mapping(source = "orderState", target = "orderState"), // Mapping source state to target state
                    @Mapping(source = "userEntity.id", target = "userId") // Mapping source userEntity.id to target userId
            }
    )

    Order toOrder(OrderEntity orderEntity); // Method for converting OrderEntity to Order
    Iterable<Order> toOrderList(Iterable<OrderEntity> orderEntities); // Method for converting list of OrderEntity to list of Order

    @InheritInverseConfiguration // Annotation to inherit inverse mapping configuration
    OrderEntity toOrderEntity(Order order); // Method for converting Order to OrderEntity
}
