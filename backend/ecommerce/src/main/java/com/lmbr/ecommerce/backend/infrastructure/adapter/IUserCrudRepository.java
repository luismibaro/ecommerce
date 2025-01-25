// Define the package where this interface resides.
package com.lmbr.ecommerce.backend.infrastructure.adapter;

// Import the UserEntity class and CrudRepository interface.
import com.lmbr.ecommerce.backend.infrastructure.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface IUserCrudRepository extends CrudRepository<UserEntity,Integer> {
}
