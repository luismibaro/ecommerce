// Define the package where this class resides.
package com.lmbr.ecommerce.backend.infrastructure.rest;

// Import necessary classes/interfaces.
import com.lmbr.ecommerce.backend.application.UserService;
import com.lmbr.ecommerce.backend.domain.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
//http://localhost:8085
// Define the base URL for all endpoints in this controller.
@RequestMapping("/api/v1/users")
//http://localhost:8085//api/v1/users
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    // Dependency injection of the UserService instance.
    private final UserService userService;

    // Constructor to initialize the UserController with UserService dependency.
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Endpoint for saving a user. Handles HTTP POST requests.
    @PostMapping
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    // Endpoint for finding a user by ID. Handles HTTP GET requests.
    // Path variable {id} is dynamically replaced with the provided ID.
    // For example, if the URL is /api/v1/users/4, id will be 4.
    @GetMapping("/{id}")
    public User findById(@PathVariable Integer id) {
        return userService.findById(id);
    }
}
