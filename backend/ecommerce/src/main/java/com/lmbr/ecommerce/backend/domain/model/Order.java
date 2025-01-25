package com.lmbr.ecommerce.backend.domain.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents an order in the e-commerce system.
 * It contains information such as the order ID, creation date,
 * list of products in the order, order state, and the associated user ID.
 */
@Data
public class Order {
    private Integer id; // Unique identifier for the order
    private LocalDateTime dateCreated; // Date and time when the order was created
    private List<OrderProduct> orderProducts; // List of products in the order
    private OrderState orderState; // Current state of the order
    private Integer userId; // ID of the user who placed the order

    /**
     * Default constructor initializes the list of order products.
     */
    public Order() {
        orderProducts = new ArrayList<>();
    }

    /**
     * Calculates the total price of the order by summing up
     * the total price of each product in the order.
     *
     * @return The total price of the order as a BigDecimal.
     */
    public BigDecimal getTotalOrderPrice(){
        return this.orderProducts.stream().map(orderProduct -> orderProduct.getTotalItem() ).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
