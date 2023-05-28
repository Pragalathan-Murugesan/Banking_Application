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
@Table(name = "employeeDetails")
public class Employee_Details_Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "locationh")
    private String locationh;
    @Column(name = "employeeName")
    private String employeeName;
    @Column(name = "employeeEmailID")
    private String employeeEmailID;
    @Column(name = "employeeMobileNumber")
    private Long employeeMobileNumber;
    @Column(name = "date&Time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateTime = LocalDateTime.now();
}
