package com.example.Banking_Application.Bank_API_Service;

import com.example.Banking_Application.Bank_API_Entity.Bank_Loan_Entity;
import com.example.Banking_Application.Bank_API_Entity.Bank_Transaction_History_Entity;
import com.example.Banking_Application.Bank_API_Repository.Bank_Loan_Repo;
import com.example.Banking_Application.Bank_API_Service.Sign_Up_Details_Imple.Bank_Loan_Imple;
import com.example.Banking_Application.DTO.Bank_Loan_DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class Bank_Loan_Service implements Bank_Loan_Imple {
    @Autowired
    Bank_Loan_Repo bankLoanRepo;

    @Override
    public Bank_Loan_Entity addLoandDetails(Bank_Loan_Entity bankLoanEntity) throws Exception {
        try {

        }catch (Exception e){
            throw new  Exception(e.getMessage());
        }
        return bankLoanRepo.save(bankLoanEntity);
    }

    @Override
    public List<Bank_Loan_Entity> getAll() throws Exception {
        List<Bank_Loan_Entity> getLoanDetails = bankLoanRepo.findAll();
        try {
            bankLoanRepo.findAll();
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
       return getLoanDetails;
    }

    @Override
    public Bank_Loan_Entity getByName(String name) throws Exception {
        Bank_Loan_Entity getByName  = bankLoanRepo.getByName(name);
        try {
            bankLoanRepo.getByName(name);
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
        return getByName;
    }
    @Override
    public String deleteDetails(Bank_Loan_Entity id) {
        bankLoanRepo.delete(id);
        return "Id Deleted Successfully";
    }

    @Override
    public LinkedHashMap<String, Object> updateAll(Bank_Loan_DTO id) throws Exception {
        Bank_Loan_Entity updateall = bankLoanRepo.updateall(id.getId());
        LinkedHashMap<String,Object> linkedHashMap = new LinkedHashMap<>();
        try {
            if (bankLoanRepo.existsById(id.getId())){
                bankLoanRepo.save(updateall);
                updateall.setLoanAmount(id.getLoanAmount());
                updateall.setLoanName(id.getLoanName());
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
    public LinkedHashMap<String, Object> updateName(Bank_Loan_DTO id) throws Exception {
        Bank_Loan_Entity updatename = bankLoanRepo.updatename(id.getId());
        LinkedHashMap<String,Object> linkedHashMap = new LinkedHashMap<>();
        try {
            if (bankLoanRepo.existsById(id.getId())){
                bankLoanRepo.save(updatename);
                updatename.setCustomerName(id.getCustomerName());
                linkedHashMap = new LinkedHashMap<>();
                linkedHashMap.put("Message","Name updated Successfully");
                linkedHashMap.put("data",new ArrayList<>());
                return linkedHashMap;
            }else {
                linkedHashMap = new LinkedHashMap<>();
                linkedHashMap.put("Message","Name updated Failed");
                linkedHashMap.put("data",new ArrayList<>());
                return linkedHashMap;
            }
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }

    }
}
