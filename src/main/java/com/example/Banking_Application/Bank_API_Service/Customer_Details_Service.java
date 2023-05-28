package com.example.Banking_Application.Bank_API_Service;

import com.example.Banking_Application.Bank_API_Entity.Customer_Details_Entity;
import com.example.Banking_Application.Bank_API_Repository.Customer_Details_Repo;
import com.example.Banking_Application.Bank_API_Service.Sign_Up_Details_Imple.Customer_Details_Imple;
import com.example.Banking_Application.DTO.Customer_DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class Customer_Details_Service  implements Customer_Details_Imple {
    @Autowired
    private Customer_Details_Repo customerDetailsRepo;

    public Customer_Details_Entity addCustomer(Customer_Details_Entity customerDetailsEntity) throws Exception {
        try {

        }catch (Exception e ){
            throw  new Exception(e.getMessage());
        }
        return customerDetailsRepo.save(customerDetailsEntity);
    }
    @Override
    public List<Customer_Details_Entity> getAll() throws Exception {
        try {

        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
        return customerDetailsRepo.findAll();
    }

    @Override
    public Customer_Details_Entity getByName(String name) throws Exception {
        Customer_Details_Entity getName = customerDetailsRepo.findByName(name);
        try {
            customerDetailsRepo.findByName(name);
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
        return getName;
    }
    @Override
    public String deleteDetails(Customer_Details_Entity id) throws Exception {
        try {
            customerDetailsRepo.delete(id);
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
        return "Id Details Deleted Successfully";
    }

    @Override
    public  LinkedHashMap<String,Object> updateCustomerDetails(Customer_DTO id) throws Exception {
               Customer_Details_Entity updateCustomer=customerDetailsRepo.updateCustomer(id.getId());
        LinkedHashMap<String,Object> linkedHashMap =new LinkedHashMap<>();
        try {
            if (customerDetailsRepo.existsById(id.getId())){
                updateCustomer.setCustomerAccountNumber(id.getCustomerAccountNumber());
                updateCustomer.setCustomerMobileNumber(id.getCustomerMobileNumber());
                customerDetailsRepo.save(updateCustomer);
                linkedHashMap=new LinkedHashMap<>();
                linkedHashMap.put("status","Success");
                linkedHashMap.put("Message","Customer Details Updated Successfully");
                linkedHashMap.put("data", customerDetailsRepo.save(updateCustomer));
                linkedHashMap.put("data", new ArrayList());
                return linkedHashMap;
            }else {
                linkedHashMap=new LinkedHashMap<>();
                linkedHashMap.put("status","Failed");
                linkedHashMap.put("Message","Customer Details Updated Failed");
                linkedHashMap.put("data", new ArrayList());
                return linkedHashMap;
            }

        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    @Override
    public LinkedHashMap<String, Object> updateCustomerName(Customer_DTO id) throws Exception {
        Customer_Details_Entity updateName =customerDetailsRepo.updateName(id.getId());
        LinkedHashMap linkedHashMap=new LinkedHashMap<>();
        try {
            if (customerDetailsRepo.existsById(id.getId())){
                updateName.setCustomerName(id.getCustomerName());
                customerDetailsRepo.save(updateName);
                linkedHashMap =new LinkedHashMap<>();
                linkedHashMap.put("Status","Success");
                linkedHashMap.put("Message","Customer Name Updated Successfully");
                linkedHashMap.put("data",new ArrayList());
                return linkedHashMap;
            }else{
                linkedHashMap =new LinkedHashMap<>();
                linkedHashMap.put("Status","Failed");
                linkedHashMap.put("Message","Customer Name Updated Failed");
                linkedHashMap.put("data",new ArrayList());
                return linkedHashMap;
            }
        }catch (Exception e){
            throw  new Exception((e.getMessage()));
        }
    }
}
