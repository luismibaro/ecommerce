package com.lmbr.ecommerce.backend.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * This class represents the entity for products in the database.
 */
@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // This field contains the unique identifier for the product in the database.
    private String name; // This field contains the name of the product.
    private String code; // This field contains the code used to identify the product.
    private String description; // This field contains the description of the product.
    private String urlImage; // This field contains the URL of the product image.
    private BigDecimal price; // This field contains the price of the product.

    @CreationTimestamp
    private LocalDateTime dateCreated; // This field contains the date and time when the product was created.

    @UpdateTimestamp
    private LocalDateTime dateUpdated; // This field contains the date and time when the product was last updated.

    @ManyToOne
    private UserEntity userEntity; // This field represents the user associated with the product.

    @ManyToOne
    private CategoryEntity categoryEntity; // This field represents the category associated with the product.
}
