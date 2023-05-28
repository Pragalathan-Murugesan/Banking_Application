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
@Table(name = "customerDetails")
public class Customer_Details_Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "customerName")
    private String customerName;
    @Column(name = "customerAccountNumber")
    private Long customerAccountNumber;
    @Column(name = "customerMobileNumber")
    private Long customerMobileNumber;
    @Column(name = "date&Time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateandTime = LocalDateTime.now();
}
