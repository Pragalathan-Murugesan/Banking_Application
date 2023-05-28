package com.example.Banking_Application.Bank_API_Service.Sign_Up_Details_Imple;

import com.example.Banking_Application.Bank_API_Entity.Bank_Transaction_History_Entity;
import com.example.Banking_Application.DTO.Bank_Transaction_DTO;
import com.example.Banking_Application.DTO.DTO_Interfaces.Customer_Details;

import java.util.LinkedHashMap;
import java.util.List;

public interface Bank_Transaction_Imple {

    List<Bank_Transaction_History_Entity> getAllTransaction() throws Exception;

    Bank_Transaction_History_Entity getByName(String name) throws Exception;


    String deleteDetails(Bank_Transaction_History_Entity id);

    LinkedHashMap<String, Object> updateAll(Bank_Transaction_DTO id) throws Exception;

    LinkedHashMap<String, Object> updateMinAmount(Bank_Transaction_DTO id) throws Exception;

    Bank_Transaction_History_Entity addTransactionHistory(Bank_Transaction_History_Entity bankTransactionHistoryEntity) throws Exception;

    List<Customer_Details> customerName(Long id) throws Exception;
}
