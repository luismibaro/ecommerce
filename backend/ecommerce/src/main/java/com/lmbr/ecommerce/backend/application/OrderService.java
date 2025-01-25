package com.lmbr.ecommerce.backend.application;

import com.lmbr.ecommerce.backend.domain.model.Order;
import com.lmbr.ecommerce.backend.domain.port.IOrderRepository;

import javax.swing.*;
import javax.swing.border.Border;

/**
 * This class represents the service layer for managing orders in the e-commerce application.
 * It provides methods for saving orders, retrieving all orders, finding orders by user ID,
 * and updating the state of an order by its ID.
 */
public class OrderService {

    private final IOrderRepository iOrderRepository; // Interface for interacting with order repository

    /**
     * Constructs an OrderService with the provided order repository implementation.
     * @param iOrderRepository The order repository implementation to be used.
     */
    public OrderService(IOrderRepository iOrderRepository) {
        this.iOrderRepository = iOrderRepository; // Initialize the order repository
    }

    /**
     * Saves the given order.
     * @param order The order to be saved.
     * @return The saved order.
     */
    public Order save(Order order){
        return  this.iOrderRepository.save(order); // Delegates saving to the order repository
    }

    /**
     * Retrieves all orders.
     * @return An iterable collection of orders.
     */
    public Iterable<Order> findAll(){
        return this.iOrderRepository.findAll(); // Delegates finding all orders to the order repository
    }

    /**
     * Finds orders by user ID.
     * @param userId The ID of the user whose orders are to be found.
     * @return An iterable collection of orders associated with the specified user ID.
     */
    public Iterable<Order> findByUserId(Integer userId){
        return this.iOrderRepository.findByUserId(userId); // Delegates finding orders by user ID to the order repository
    }

    /**
     * Updates the state of an order by its ID.
     * @param id The ID of the order to be updated.
     * @param state The new state of the order.
     */
    public void updateStateById(Integer id, String state){
        this.iOrderRepository.updateStateById(id, state); // Delegates updating order state to the order repository
    }

    public Order findById(Integer id){ // Method for finding an order by ID
        return  this.iOrderRepository.findById(id); // Delegating finding an order by ID to the order repository
    }
}
