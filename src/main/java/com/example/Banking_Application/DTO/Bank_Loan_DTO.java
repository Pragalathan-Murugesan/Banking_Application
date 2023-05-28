package com.example.Banking_Application.DTO;

import lombok.Data;

@Data
public class Bank_Loan_DTO {
    private Long id;
    private  String loanName;
    private  Long loanAmount;
    private String customerName;

}
