package com.lmbr.ecommerce.backend.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data // Automatically generates getters, setters, toString, equals, and hashCode
@AllArgsConstructor // Automatically generates a constructor with all fields
@NoArgsConstructor // Automatically generates a no-argument constructor
public class Category {

    // Attribute representing the category's ID
    private Integer id;

    // Attribute representing the category's name
    private String name;

    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;
}
