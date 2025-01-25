// Define the package where this class resides.
package com.lmbr.ecommerce.backend.infrastructure.config;

// Import necessary classes/interfaces.
import com.lmbr.ecommerce.backend.application.*;
import com.lmbr.ecommerce.backend.domain.port.ICategoryRepository; // Importing ICategoryRepository interface
import com.lmbr.ecommerce.backend.domain.port.IOrderRepository; // Importing IOrderRepository interface
import com.lmbr.ecommerce.backend.domain.port.IProductRepository; // Importing IProductRepository interface
import com.lmbr.ecommerce.backend.domain.port.IUserRepository; // Importing IUserRepository interface
import org.springframework.context.annotation.Bean; // Importing Bean annotation for defining Spring beans
import org.springframework.context.annotation.Configuration; // Importing Configuration annotation for defining Spring configuration

/**
 * Configuration class defining Spring beans for various services.
 */
@Configuration // Annotation to mark this class as a Spring configuration class
public class BeanConfiguration { // Declaration of class

    /**
     * Defines a bean for UserService.
     * @param iUserRepository UserRepository interface implementation.
     * @return UserService instance.
     */
    @Bean // Annotation to define a Spring bean
    public UserService userService(IUserRepository iUserRepository){ // Method to create a UserService bean
        return new UserService(iUserRepository); // Returning a new instance of UserService
    }

    /**
     * Defines a bean for CategoryService.
     * @param iCategoryRepository CategoryRepository interface implementation.
     * @return CategoryService instance.
     */
    @Bean // Annotation to define a Spring bean
    public CategoryService categoryService(ICategoryRepository iCategoryRepository){ // Method to create a CategoryService bean
        return new CategoryService(iCategoryRepository); // Returning a new instance of CategoryService
    }

    /**
     * Defines a bean for ProductService.
     * @param iProductRepository ProductRepository interface implementation.
     * @return ProductService instance.
     */
    @Bean // Annotation to define a Spring bean
    public ProductService productService (IProductRepository iProductRepository, UploadFile uploadFile){ // Method to create a ProductService bean
        return new ProductService(iProductRepository, uploadFile); // Returning a new instance of ProductService
    }

    /**
     * Defines a bean for OrderService.
     * @param iOrderRepository OrderRepository interface implementation.
     * @return OrderService instance.
     */
    @Bean // Annotation to define a Spring bean
    public OrderService orderService(IOrderRepository iOrderRepository){ // Method to create an OrderService bean
        return new OrderService(iOrderRepository); // Returning a new instance of OrderService
    }

    @Bean
    public UploadFile uploadFile(){
        return new UploadFile();
    }

}
