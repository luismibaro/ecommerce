package com.lmbr.ecommerce.backend.domain.model;

import lombok.Data;  // Importing lombok annotation to automatically generate getter, setter, and other useful methods.

import java.math.BigDecimal; // Importing the BigDecimal class from the java.math package to handle decimal numbers with precision.

@Data // The lombok @Data annotation automatically generates getter, setter, equals, hashCode, and toString methods for all the class attributes.
public class OrderProduct { // Declaring the OrderProduct class.

    private Integer id; // Declaring an id attribute of type Integer to store the product identifier in the order.
    private BigDecimal quantity; // Declaring a quantity attribute of type BigDecimal to store the quantity of the product in the order.
    private BigDecimal price; // Declaring a price attribute of type BigDecimal to store the price of the product in the order.
    private Integer productId; // Declaring a productId attribute of type Integer to store the product identifier.

    // Public method that calculates the total item by multiplying the quantity by the price.
    public  BigDecimal getTotalItem(){
       return this.price.multiply(quantity);
   }
}
