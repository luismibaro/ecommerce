package com.lmbr.ecommerce.backend.application;

import com.lmbr.ecommerce.backend.domain.model.User;
import com.lmbr.ecommerce.backend.domain.port.IUserRepository;

// Service class responsible for handling business logic related to users
public class UserService {

    // Injects an instance of IUserRepository to interact with the persistence layer
    private final IUserRepository iUserRepository;

    // Constructor that initializes the instance of IUserRepository
    public UserService(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    // Method to save a user in the database
    public User save(User user) {
        return this.iUserRepository.save(user);
    }

    // Method to find a user by its ID in the database
    public User findById(Integer id) {
        return this.iUserRepository.findById(id);
    }
}
