package com.lmbr.ecommerce.backend.infrastructure.mapper;

import com.lmbr.ecommerce.backend.domain.model.User;
import com.lmbr.ecommerce.backend.infrastructure.entity.UserEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

// An interface for mapping between User and UserEntity objects using MapStruct.
@Mapper(componentModel = "spring")
public interface UserMapper {

    // Define mappings between UserEntity and User.
    @Mappings(
            {
                    @Mapping(source = "id", target = "id"),
                    @Mapping(source = "username", target = "username"),
                    @Mapping(source = "lastName", target = "lastName"),
                    @Mapping(source = "email", target = "email"),
                    @Mapping(source = "address", target = "address"),
                    @Mapping(source = "cellphone", target = "cellphone"),
                    @Mapping(source = "password", target = "password"),
                    @Mapping(source = "userType", target = "userType"),
                    @Mapping(source = "dateCreated", target = "dateCreated"),
                    @Mapping(source = "dateUpdated", target = "dateUpdated")
            }
    )
    // Map UserEntity to User.
    User toUser(UserEntity userEntity);

    // Map Iterable<UserEntity> to Iterable<User>.
    Iterable<User> toUsers(Iterable<UserEntity> userEntities);

    // Inherit inverse mapping configuration.
    @InheritInverseConfiguration
    UserEntity toUserEntity(User user);
}
