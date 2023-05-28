package com.example.Banking_Application.DTO;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SignUpDetailsDTO {
    private  Long id;
    @NotNull("FirstName is Required")
    @NotEmpty(message = "Please Enter FirstName")
    @Size(min = 2,max = 17)
    private  String firstName;
    @NotNull("LastName is Required")
    @NotEmpty(message = "Please Enter LastName")
    private String lastName;
    @NotNull("EmailID is Required")
    @NotEmpty(message = "Please Enter EmailID")
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
    private String emailID;
    @NotNull("MobileNumber is Required")
    private Long mobileNumber;
    @NotNull("Location is Required")
    @NotEmpty(message = "Please Enter Location")
    private  String location;
    @NotNull( "Password is Required")
    @NotEmpty(message = "Please Enter Password")
    @Size(min = 8,max = 15)
//    @Pattern(regexp = "[a-z0-9]+@[a-z0-9]")
    private String password;
}
