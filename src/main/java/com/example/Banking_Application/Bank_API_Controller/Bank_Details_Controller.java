package com.example.Banking_Application.Bank_API_Controller;

import com.example.Banking_Application.Bank_API_Entity.Bank_Details_Entity;
import com.example.Banking_Application.Bank_API_Service.Bank_Details_Service;
import com.example.Banking_Application.Bank_API_Service.Sign_Up_Details_Imple.Bank_Details_DTO;
import com.example.Banking_Application.Bank_API_Service.Sign_Up_Details_Imple.Bank_Loan_Imple;
import com.example.Banking_Application.DTO.Bank_Details;
import com.example.Banking_Application.DTO.DTO_Interfaces.Bank_DetailsInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;

@RestController
@RequestMapping("/bankdetails")
public class Bank_Details_Controller {
    @Autowired
    Bank_Details_DTO bankDetailsService;
    @PostMapping(value = "/addbankdetails")
    public Bank_Details_Entity addBankDetails(@RequestBody Bank_Details_Entity bankDetailsEntity) throws Exception {
        return bankDetailsService.addBankDetails(bankDetailsEntity);
    }
    @GetMapping(value = "/getall")
    public List<Bank_Details_Entity> getAll() throws Exception {
        return bankDetailsService.getAll();
    }

    @GetMapping(value = "/getbyid/{id}")
    public Bank_Details_Entity getById(@PathVariable("id") Long id) throws Exception {
        return bankDetailsService.getById(id);
    }

    @DeleteMapping(value = "/deletedetails/{id}")
    public String deleteBankDetails(@PathVariable("id") Bank_Details_Entity id) throws Exception {
        return bankDetailsService.deleteNankDetails(id);
    }

   @PutMapping(value = "/updateall")
    public LinkedHashMap<String,Object> updateAll(@RequestBody Bank_Details id) throws Exception {
        return  bankDetailsService.updateAll(id);
   }
   @PatchMapping(value = "/updatebyname")
   public LinkedHashMap<String,Object> updateByName(@RequestBody Bank_Details id) throws Exception {
        return bankDetailsService.updateByName(id);
   }
   @GetMapping(value = "/getname/{name}")
    public List<Bank_DetailsInter> getName1(@PathVariable("name") String name1) throws Exception {
        return bankDetailsService.getName1(name1);
   }
}
