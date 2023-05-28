package com.example.Banking_Application.Bank_API_Service;

import com.example.Banking_Application.Bank_API_Entity.Bank_Details_Entity;
import com.example.Banking_Application.Bank_API_Entity.Bank_Loan_Entity;
import com.example.Banking_Application.Bank_API_Repository.Bank_DetailsRepo;
import com.example.Banking_Application.Bank_API_Service.Sign_Up_Details_Imple.Bank_Details_DTO;
import com.example.Banking_Application.Bank_API_Service.Sign_Up_Details_Imple.Bank_Loan_Imple;
import com.example.Banking_Application.DTO.Bank_Details;
import com.example.Banking_Application.DTO.DTO_Interfaces.Bank_DetailsInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class Bank_Details_Service implements Bank_Details_DTO {
    @Autowired
    Bank_DetailsRepo bankDetailsRepo;

    public Bank_Details_Entity addBankDetails(Bank_Details_Entity bankDetailsEntity) throws Exception {
        try {

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return bankDetailsRepo.save(bankDetailsEntity);
    }

    @Override
    public List<Bank_Details_Entity> getAll() throws Exception {
        List<Bank_Details_Entity> getall = bankDetailsRepo.findAll();
        try {
            bankDetailsRepo.findAll();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return getall;
    }

    @Override
    public Bank_Details_Entity getById(Long id) throws Exception {
        Bank_Details_Entity getByid = bankDetailsRepo.getByid(id);
        try {
            bankDetailsRepo.getByid(id);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return getByid;
    }
    @Override
    public String deleteNankDetails(Bank_Details_Entity id) throws Exception {
        try {
            bankDetailsRepo.delete(id);

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return "Id Deleted Successfully";
    }

    @Override
    public LinkedHashMap<String, Object> updateAll(Bank_Details id) throws Exception {
        Bank_Details_Entity update = bankDetailsRepo.update(id.getId());
        LinkedHashMap<String,Object> linkedHashMap = new LinkedHashMap<>();
        try {
            if (bankDetailsRepo.existsById(id.getId())){
                bankDetailsRepo.save(update);
               update.setBankName(id.getBankName());
               update.setBankManagerName(id.getBankManagerName());
                linkedHashMap = new LinkedHashMap<>();
                linkedHashMap.put("Message","Id updated Successfully");
                linkedHashMap.put("data",new ArrayList<>());
                return linkedHashMap;
            }else {
                linkedHashMap = new LinkedHashMap<>();
                linkedHashMap.put("Message","Id updated Failed");
                linkedHashMap.put("data",new ArrayList<>());
                return linkedHashMap;
            }
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    @Override
    public LinkedHashMap<String, Object> updateByName(Bank_Details id) throws Exception {
        Bank_Details_Entity updateBY = bankDetailsRepo.updateBy(id.getId());
        LinkedHashMap<String,Object> linkedHashMap = new LinkedHashMap<>();
        try {
            if (bankDetailsRepo.existsById(id.getId())){
                bankDetailsRepo.save(updateBY);
                updateBY.setBankName(id.getBankName());
                linkedHashMap = new LinkedHashMap<>();
                linkedHashMap.put("Message","Id updated Successfully");
                linkedHashMap.put("data",new ArrayList<>());
                return linkedHashMap;
            }else {
                linkedHashMap = new LinkedHashMap<>();
                linkedHashMap.put("Message","Id updated Failed");
                linkedHashMap.put("data",new ArrayList<>());
                return linkedHashMap;
            }
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }
    @Override
    public List<Bank_DetailsInter> getName1(String name1) throws Exception {
        List<Bank_DetailsInter> getByName = bankDetailsRepo.findAll(name1);
        try {
            bankDetailsRepo.findAll(name1);
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
        return getByName;
    }
    }


