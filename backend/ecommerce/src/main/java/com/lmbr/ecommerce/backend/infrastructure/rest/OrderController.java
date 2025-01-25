package com.lmbr.ecommerce.backend.infrastructure.rest; // Package declaration

import com.lmbr.ecommerce.backend.application.OrderService; // Importing OrderService class
import com.lmbr.ecommerce.backend.domain.model.Order; // Importing Order domain model
import com.lmbr.ecommerce.backend.domain.model.OrderState; // Importing OrderState enum
import lombok.extern.slf4j.Slf4j; // Importing Lombok annotation for logging
import org.aspectj.weaver.ast.Or;
import org.springframework.http.ResponseEntity; // Importing ResponseEntity for HTTP response handling
import org.springframework.web.bind.annotation.*; // Importing Spring annotations for REST controller

@RestController // Annotation to mark this class as a REST controller
@RequestMapping("api/v1/orders") // Annotation to specify the base URL for all endpoints in this controller
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j // Lombok annotation for logging
public class OrderController { // Declaration of class

    private final OrderService orderService; // Declaration of OrderService instance

    public OrderController(OrderService orderService) { // Constructor for injecting OrderService dependency
        this.orderService = orderService;
    }

    @PostMapping // Annotation to handle HTTP POST requests
    public ResponseEntity<Order> save(@RequestBody Order order){ // Method for handling POST request to save an order
        if (order.getOrderState().toString().equals(OrderState.CANCELLED.toString()) ){ // Checking if the order state is cancelled
            order.setOrderState(OrderState.CANCELLED); // Setting order state to cancel if it matches
        } else {
            order.setOrderState(OrderState.CONFIRMED); // Setting order state to confirm if it doesn't match cancelled
        }
        return ResponseEntity.ok(orderService.save(order)); // Returning HTTP response with the saved order
    }

    @PostMapping("/update/state/order") // Annotation to handle HTTP POST requests with a specific path
    public ResponseEntity updateStateById(@RequestParam Integer id, @RequestParam String state){ // Method for handling POST request to update order state by ID
        orderService.updateStateById(id, state); // Updating order state
        return ResponseEntity.ok().build(); // Returning HTTP response with status 200 (OK)
    }

    @GetMapping // Annotation to handle HTTP GET requests
    public ResponseEntity<Iterable<Order>> findAll(){ // Method for handling GET request to retrieve all orders
        return ResponseEntity.ok(orderService.findAll()); // Returning HTTP response with all orders
    }

    @GetMapping("{variable}") // Annotation to handle HTTP GET requests with a dynamic path variable
    public ResponseEntity<Order> findById(@PathVariable("variable") Integer id){ // Method for handling GET request to find an order by ID
        return ResponseEntity.ok(orderService.findById(id)); // Returning HTTP response with the found order
    }

    @GetMapping("/by-user/{id}") // Annotation to handle HTTP GET requests with a specific path
    public ResponseEntity<Iterable<Order>> findByUser(@PathVariable("id") Integer userId){ // Method for handling GET request to find orders by user ID
        return ResponseEntity.ok(orderService.findByUserId(userId)); // Returning HTTP response with orders found by user ID
    }
}


