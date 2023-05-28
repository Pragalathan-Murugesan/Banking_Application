package com.example.Banking_Application.Bank_API_Controller;

import com.example.Banking_Application.Bank_API_Entity.Bank_Transaction_History_Entity;
import com.example.Banking_Application.Bank_API_Service.Bank_Transaction_History_Service;
import com.example.Banking_Application.Bank_API_Service.Sign_Up_Details_Imple.Bank_Transaction_Imple;
import com.example.Banking_Application.DTO.Bank_Transaction_DTO;
import com.example.Banking_Application.DTO.DTO_Interfaces.Customer_Details;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;

@RestController
@RequestMapping("/banktransaction")
public class Bank_Transaction_History_Controller {
    @Autowired
    Bank_Transaction_Imple bankTransactionHistoryService;

    @PostMapping(value = "/addtransactionhistory")
    public Bank_Transaction_History_Entity addTransactionHistory(@RequestBody Bank_Transaction_History_Entity bankTransactionHistoryEntity) throws Exception {
        return bankTransactionHistoryService.addTransactionHistory(bankTransactionHistoryEntity);
    }

    @GetMapping(value = "/getall")
    public List<Bank_Transaction_History_Entity> getAllTransaction() throws Exception {
        return bankTransactionHistoryService.getAllTransaction();
    }

    @GetMapping(value = "/getbyname/{name}")
    public Bank_Transaction_History_Entity getByName(@PathVariable("name") String name) throws Exception {
        return bankTransactionHistoryService.getByName(name);
    }

    @DeleteMapping(value = "/deletedetails/{id}")
    public String deleteDetails(@PathVariable("id") Bank_Transaction_History_Entity id) {
        return bankTransactionHistoryService.deleteDetails(id);
    }

    @PutMapping(value = "/updateall")
    public LinkedHashMap<String, Object> updateAll(@RequestBody Bank_Transaction_DTO id) throws Exception {
        return bankTransactionHistoryService.updateAll(id);
    }
    @PatchMapping("/updateminamount")
    public LinkedHashMap<String,Object> updateMinAmount(@RequestBody Bank_Transaction_DTO id) throws Exception {
        return bankTransactionHistoryService.updateMinAmount(id);
    }

    @GetMapping(value = "/customername/{id}")
    public List<Customer_Details> customerName(@PathVariable("id") Long id) throws Exception {
        return bankTransactionHistoryService.customerName(id);
    }
}
