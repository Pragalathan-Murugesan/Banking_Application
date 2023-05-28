package com.example.Banking_Application.Bank_API_Service.Sign_Up_Details_Imple;

import com.example.Banking_Application.Bank_API_Entity.Bank_Loan_Entity;
import com.example.Banking_Application.Bank_API_Entity.Bank_Transaction_History_Entity;
import com.example.Banking_Application.DTO.Bank_Loan_DTO;

import java.util.LinkedHashMap;
import java.util.List;

public interface Bank_Loan_Imple {
    Bank_Loan_Entity addLoandDetails(Bank_Loan_Entity bankLoanEntity) throws Exception;

    List<Bank_Loan_Entity> getAll() throws Exception;

    Bank_Loan_Entity getByName(String name) throws Exception;

    String deleteDetails(Bank_Loan_Entity id);

    LinkedHashMap<String, Object> updateAll(Bank_Loan_DTO id) throws Exception;

    LinkedHashMap<String, Object> updateName(Bank_Loan_DTO id) throws Exception;
}
