package com.example.Banking_Application.Bank_API_Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "SignUpDetails")
public class SignUp_Details_Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "mobileNumber")
    private int mobileNumber;

    @Column(name = "emailID")
    private String emailID;
    @Column(name = "location")
    private String location;
    @Column(name = "password")
    private String password;
    @Column(name = "date&Time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateandTime = LocalDateTime.now();
}