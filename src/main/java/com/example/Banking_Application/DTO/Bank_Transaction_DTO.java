package com.example.Banking_Application.DTO;

import lombok.Data;

@Data
public class Bank_Transaction_DTO {

    private  Long id;
    private Long minTransactionAmount;
    private Long maxTransactionAmount;
}
