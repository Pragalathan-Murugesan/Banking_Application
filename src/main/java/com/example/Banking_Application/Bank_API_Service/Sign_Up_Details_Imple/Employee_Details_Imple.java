package com.example.Banking_Application.Bank_API_Service.Sign_Up_Details_Imple;

import com.example.Banking_Application.Bank_API_Entity.Employee_Details_Entity;
import com.example.Banking_Application.DTO.DTO_Interfaces.EmployeeDetails;
import com.example.Banking_Application.DTO.Employee_Details_DTO;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

public interface Employee_Details_Imple {
    Employee_Details_Entity addEmployee(Employee_Details_Entity employeeDetailsEntity) throws Exception;

    List<Employee_Details_Entity> getAll() throws Exception;

    Optional<Employee_Details_Entity> getBy(String name);

    String deleteByIdEmp(Employee_Details_Entity id) throws Exception;

    LinkedHashMap<String, Object> updateEmpDetails(Employee_Details_DTO id) throws Exception;

    LinkedHashMap<String, Object> updatePassword(Employee_Details_DTO name) throws Exception;

    List<EmployeeDetails> getLocation(String name) throws Exception;

}
