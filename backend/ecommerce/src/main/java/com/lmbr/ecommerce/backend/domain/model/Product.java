package com.lmbr.ecommerce.backend.domain.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Integer id; //Contains code in the database to reference the product.
    private String name; //Contains product name.
    private String code; //Contains code to select the product.
    private String description; //Contains the product description.
    private String urlImage; //Contains url of the product image.
    private BigDecimal price; //Contains the value of that product.
    private LocalDateTime dateCreated; //Contains the date of creation.
    private LocalDateTime dateUpdated; //Contains the update date of that record.
    private Integer userId; //Contains the representation of this class with the user class.
    private Integer categoryId; //Contains the category to which the product belongs.
}

