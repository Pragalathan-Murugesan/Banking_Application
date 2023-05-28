package com.example.Banking_Application.Bank_API_Controller;

import com.example.Banking_Application.Bank_API_Entity.Bank_Loan_Entity;
import com.example.Banking_Application.Bank_API_Entity.Bank_Transaction_History_Entity;
import com.example.Banking_Application.Bank_API_Service.Bank_Loan_Service;
import com.example.Banking_Application.Bank_API_Service.Sign_Up_Details_Imple.Bank_Loan_Imple;
import com.example.Banking_Application.DTO.Bank_Loan_DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;

@RestController
@RequestMapping("/bankloan")
public class Bank_Loan_Controller {
    @Autowired
    private Bank_Loan_Imple bankLoanService;
    @PostMapping(value = "/addloandetails")
    public Bank_Loan_Entity addLoanDetails(@RequestBody Bank_Loan_Entity bankLoanEntity) throws Exception {
        return bankLoanService.addLoandDetails(bankLoanEntity);
    }

    @GetMapping(value = "/getall")
    public List<Bank_Loan_Entity> getALL() throws Exception {
        return bankLoanService.getAll();
    }
    @GetMapping(value = "/getbyname/{name}")
    public Bank_Loan_Entity getByName(@PathVariable("name") String name) throws Exception {
        return bankLoanService.getByName(name);
    }
    @DeleteMapping(value = "/deletedetails/{id}")
    public String deleteDetails(@PathVariable("id") Bank_Loan_Entity id){
        return bankLoanService.deleteDetails(id);
    }

    @PutMapping(value = "/updateall")
    public LinkedHashMap<String,Object> updateAll(@RequestBody Bank_Loan_DTO id) throws Exception {
        return bankLoanService.updateAll(id);
    }

    @PatchMapping(value = "/updatename")
    public  LinkedHashMap<String,Object> updateName(@RequestBody Bank_Loan_DTO id) throws Exception {
        return bankLoanService.updateName(id);
    }
}
