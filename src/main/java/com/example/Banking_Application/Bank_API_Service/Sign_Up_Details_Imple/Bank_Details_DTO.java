package com.example.Banking_Application.Bank_API_Service.Sign_Up_Details_Imple;

import com.example.Banking_Application.Bank_API_Entity.Bank_Details_Entity;
import com.example.Banking_Application.DTO.Bank_Details;
import com.example.Banking_Application.DTO.DTO_Interfaces.Bank_DetailsInter;

import java.util.LinkedHashMap;
import java.util.List;

public interface Bank_Details_DTO
{

    List<Bank_Details_Entity> getAll() throws Exception;

    Bank_Details_Entity getById(Long id) throws Exception;

    String deleteNankDetails(Bank_Details_Entity id) throws Exception;

    LinkedHashMap<String, Object> updateAll(Bank_Details id) throws Exception;

    LinkedHashMap<String, Object> updateByName(Bank_Details id) throws Exception;

    Bank_Details_Entity addBankDetails(Bank_Details_Entity bankDetailsEntity) throws Exception;

    List<Bank_DetailsInter> getName1(String name1) throws Exception;
}
