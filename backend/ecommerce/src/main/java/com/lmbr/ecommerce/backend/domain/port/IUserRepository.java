package com.lmbr.ecommerce.backend.domain.port;

import com.lmbr.ecommerce.backend.domain.model.User;

//Methods used for the administration of the user entity.
public interface IUserRepository {
    User save(User user); //Method that stores a user in the database.
    User findByEmail(String email); //Method that obtains a user by filtering by their email address.
    User findById(Integer id); //Method that obtains a user by filtering by user id.
}
