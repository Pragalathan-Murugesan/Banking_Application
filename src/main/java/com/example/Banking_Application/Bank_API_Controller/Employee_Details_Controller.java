package com.example.Banking_Application.Bank_API_Controller;

import com.example.Banking_Application.Bank_API_Entity.Employee_Details_Entity;
import com.example.Banking_Application.Bank_API_Service.Sign_Up_Details_Imple.Employee_Details_Imple;
import com.example.Banking_Application.DTO.DTO_Interfaces.EmployeeDetails;
import com.example.Banking_Application.DTO.Employee_Details_DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class Employee_Details_Controller {

    @Autowired
    private Employee_Details_Imple employeeDetailsService;

    @PostMapping(value = "addemployee")
    public Employee_Details_Entity addEmployee(@RequestBody Employee_Details_Entity employeeDetailsEntity) throws Exception {
        return employeeDetailsService.addEmployee(employeeDetailsEntity);
    }

    @GetMapping(value = "/getall")
    public List<Employee_Details_Entity> getAll() throws Exception {
        return employeeDetailsService.getAll();
    }

    @GetMapping(value = "/getby/{name}")
    public Optional<Employee_Details_Entity> getBy(@PathVariable("name") String name)  {
        return employeeDetailsService.getBy(name);
    }
    @DeleteMapping(value = "/deleteemployee/{id}")
    public String deleteByIdEmp(@PathVariable("id") Employee_Details_Entity id) throws Exception {
        return employeeDetailsService.deleteByIdEmp(id);
    }
    @PutMapping(value = "/updateempdetails")
    public LinkedHashMap<String, Object> updateEmpDetails(@RequestBody Employee_Details_DTO id) throws Exception {
        return employeeDetailsService.updateEmpDetails(id);
    }
    @PatchMapping(value = "changepassword")
    public LinkedHashMap<String, Object> updatePassword(@RequestBody Employee_Details_DTO name) throws Exception {
        return employeeDetailsService.updatePassword(name);
    }
    @GetMapping(value = "/getlocation/{name}")
    public List<EmployeeDetails> getLocation(@PathVariable("name") String name) throws Exception {
        return employeeDetailsService.getLocation(name);
    }
}
