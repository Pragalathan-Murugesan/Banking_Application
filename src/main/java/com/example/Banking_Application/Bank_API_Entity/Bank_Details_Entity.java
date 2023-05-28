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
@Table(name ="bankDetails")
public class Bank_Details_Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "bankName")
    private String bankName;
    @Column(name = "bankManagerName")
    private String bankManagerName;
    @Column(name = "bankBranchesName")
    private String bankBranchesName;
    @Column(name = "date&Time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateandTime = LocalDateTime.now();
}
