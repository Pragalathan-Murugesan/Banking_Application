package com.example.Banking_Application.Bank_API_Service.Sign_Up_Details_Imple;

import com.example.Banking_Application.Bank_API_Entity.Customer_Details_Entity;
import com.example.Banking_Application.DTO.Customer_DTO;

import java.util.LinkedHashMap;
import java.util.List;

public interface Customer_Details_Imple {

    Customer_Details_Entity addCustomer(Customer_Details_Entity customerDetailsEntity) throws Exception;

   List<Customer_Details_Entity>  getAll() throws Exception;

    Customer_Details_Entity getByName(String name) throws Exception;

    String deleteDetails(Customer_Details_Entity id) throws Exception;

    LinkedHashMap<String,Object> updateCustomerDetails(Customer_DTO id) throws Exception;

    LinkedHashMap<String, Object> updateCustomerName(Customer_DTO name) throws Exception;
}
