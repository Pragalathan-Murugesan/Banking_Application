package com.example.Banking_Application.Bank_API_Service;

import com.example.Banking_Application.Bank_API_Entity.Bank_Transaction_History_Entity;
import com.example.Banking_Application.Bank_API_Repository.Bank_Transaction_History_Repo;
import com.example.Banking_Application.Bank_API_Service.Sign_Up_Details_Imple.Bank_Transaction_Imple;
import com.example.Banking_Application.DTO.Bank_Transaction_DTO;
import com.example.Banking_Application.DTO.DTO_Interfaces.Customer_Details;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class Bank_Transaction_History_Service implements Bank_Transaction_Imple {
    @Autowired
    private Bank_Transaction_History_Repo bankTransactionHistoryRepo;

    public Bank_Transaction_History_Entity addTransactionHistory(Bank_Transaction_History_Entity bankTransactionHistoryEntity) throws Exception {
        try {
            bankTransactionHistoryRepo.save(bankTransactionHistoryEntity);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return bankTransactionHistoryRepo.save(bankTransactionHistoryEntity);
    }


    @Override
    public List<Bank_Transaction_History_Entity> getAllTransaction() throws Exception {
        List  <Bank_Transaction_History_Entity> getAll=bankTransactionHistoryRepo.findAll();
        try {
            bankTransactionHistoryRepo.findAll();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return getAll;
    }
    @Override
    public Bank_Transaction_History_Entity getByName(String name) throws Exception {
        Bank_Transaction_History_Entity getName = bankTransactionHistoryRepo.getByName(name);
        try {
            bankTransactionHistoryRepo.getByName(name);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return getName;
    }
    @Override
    public String deleteDetails(Bank_Transaction_History_Entity id) {
        bankTransactionHistoryRepo.delete(id);
        return "Id Deleted Successfully";
    }
    @Override
    public LinkedHashMap<String, Object> updateAll(Bank_Transaction_DTO id) throws Exception {
        Bank_Transaction_History_Entity update = bankTransactionHistoryRepo.update(id.getId());
        LinkedHashMap<String,Object> linkedHashMap =new LinkedHashMap<>();
        try{
            if (bankTransactionHistoryRepo.existsById(id.getId())){
                bankTransactionHistoryRepo.save(update);
                update.setMaxTransactionAmount(id.getMaxTransactionAmount());
                update.setMinTransactionAmount(id.getMinTransactionAmount());
                linkedHashMap= new LinkedHashMap<>();
                linkedHashMap.put("Message","Id field Updated Successfully");
                linkedHashMap.put("data", new  ArrayList());
                return linkedHashMap;
            }else {
                linkedHashMap= new LinkedHashMap<>();
                linkedHashMap.put("Message","Id field Updated Failed");
                linkedHashMap.put("data", new  ArrayList());
                return linkedHashMap;
            }

        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    @Override
    public LinkedHashMap<String, Object> updateMinAmount(Bank_Transaction_DTO id) throws Exception {
        Bank_Transaction_History_Entity updateMin = bankTransactionHistoryRepo.updateMin(id.getId());
        LinkedHashMap<String,Object> linkedHashMap = new LinkedHashMap<>();
        try {
            if (bankTransactionHistoryRepo.existsById(id.getId())){
                updateMin.setMinTransactionAmount(id.getMinTransactionAmount());
                bankTransactionHistoryRepo.save(updateMin);
                linkedHashMap= new LinkedHashMap<>();
                linkedHashMap.put("Message","Min field Updated Successfully");
                linkedHashMap.put("data", new  ArrayList());
                return linkedHashMap;
            }else {
                linkedHashMap= new LinkedHashMap<>();
                linkedHashMap.put("Message","Min field Updated Failed");
                linkedHashMap.put("data", new  ArrayList());
                return linkedHashMap;
            }

        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    @Override
    public List<Customer_Details> customerName(Long id) throws Exception {
        List<Customer_Details> getIdb = bankTransactionHistoryRepo.findAll(id);
        try {
            bankTransactionHistoryRepo.findAll(id);
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
        return getIdb;
    }

}