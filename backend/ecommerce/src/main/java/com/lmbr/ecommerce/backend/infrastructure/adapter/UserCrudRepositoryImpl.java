// Define the package where this class resides.
package com.lmbr.ecommerce.backend.infrastructure.adapter;

// Import necessary classes/interfaces.
import com.lmbr.ecommerce.backend.domain.model.User;
import com.lmbr.ecommerce.backend.domain.port.IUserRepository;
import com.lmbr.ecommerce.backend.infrastructure.mapper.UserMapper;
import org.springframework.stereotype.Repository;

// An implementation of IUserRepository that interacts with the database using CRUD operations.
@Repository
public class UserCrudRepositoryImpl implements IUserRepository {

    // Dependency on IUserCrudRepository for direct database interaction.
    private final IUserCrudRepository iUserCrudRepository;

    // Dependency on UserMapper for mapping between User and its entity representation.
    private final UserMapper userMapper;

    // Constructor for dependency injection.
    public UserCrudRepositoryImpl(IUserCrudRepository iUserCrudRepository, UserMapper userMapper) {
        this.iUserCrudRepository = iUserCrudRepository;
        this.userMapper = userMapper;
    }

    // Save a user in the database.
    @Override
    public User save(User user) {
        return userMapper.toUser(iUserCrudRepository.save(userMapper.toUserEntity(user)));
    }

    // Find a user by email (not implemented in this example).
    @Override
    public User findByEmail(String email) {
        return null; // Not implemented for brevity
    }

    // Find a user by its ID in the database.
    @Override
    public User findById(Integer id) {
        return userMapper.toUser(iUserCrudRepository.findById(id).get());
    }
}
