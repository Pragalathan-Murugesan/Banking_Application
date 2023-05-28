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
@Table(name ="LoanDetails")

public class Bank_Loan_Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "loanName")
    private String loanName;
    @Column(name = "customerName")
    private String customerName;

    @Column(name = "loanAmount")
    private Long loanAmount;
    @Column(name = "date&Time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateandTime = LocalDateTime.now();
}
