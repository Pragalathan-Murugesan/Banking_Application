package com.example.Banking_Application.Bank_API_Controller;

import com.example.Banking_Application.Bank_API_Entity.Customer_Details_Entity;
import com.example.Banking_Application.Bank_API_Service.Customer_Details_Service;
import com.example.Banking_Application.Bank_API_Service.Sign_Up_Details_Imple.Customer_Details_Imple;
import com.example.Banking_Application.DTO.Customer_DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;

@RestController
@RequestMapping("/customerdetails")
public class Customer_Details_Controller {
    @Autowired
    private Customer_Details_Imple customerDetailsService;

    @PostMapping(value = "/addcustomer")
    public Customer_Details_Entity addCustomer(@RequestBody Customer_Details_Entity customerDetailsEntity) throws Exception {
        return customerDetailsService.addCustomer(customerDetailsEntity);
    }
    @GetMapping(value = "/getall")
    public List<Customer_Details_Entity> getAll() throws Exception {
        return customerDetailsService.getAll();
    }
    @GetMapping(value = "/getbyname/{name}")
    public Customer_Details_Entity getByName(@PathVariable("name") String name) throws Exception {
        return customerDetailsService.getByName(name);
    }
    @DeleteMapping(value = "/deleteid/{id}")
    public String deleteDetails(@PathVariable("id") Customer_Details_Entity id) throws Exception {
        return customerDetailsService.deleteDetails(id);
    }
    @PutMapping(value = "/updatecustomerdetails")
    public LinkedHashMap<String,Object> updateCustomerDetails(@RequestBody Customer_DTO id) throws Exception {
        return  customerDetailsService.updateCustomerDetails(id);
    }
    @PatchMapping(value = "/updatename")
    public LinkedHashMap<String,Object> updateCustomerName(@RequestBody Customer_DTO id) throws Exception {
        return  customerDetailsService.updateCustomerName(id);
    }
}
