package com.lmbr.ecommerce.backend.domain.model;
import lombok.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id; //Specifies the id of each data record.
    private String username; //Specifies the username.
    private String firstName; //Specifies the firstname.
    private String lastName; //Specifies the lastname.
    private String email; //Specify mail of the user.
    private String address; //Specifies the user address.
    private String cellphone; //Specifies the cellphone of the user.
    private String password; //Specifies the user password.
    private UserType userType; //Specifies the type of user 'admin' or 'user'.
    private LocalDateTime dateCreated; //Date and time of user creation
    private LocalDateTime dateUpdated; //Update date and time of user creation

}
