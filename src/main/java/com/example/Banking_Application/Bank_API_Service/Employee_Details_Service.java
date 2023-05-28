package com.example.Banking_Application.Bank_API_Service;

import com.example.Banking_Application.Bank_API_Entity.Employee_Details_Entity;
import com.example.Banking_Application.Bank_API_Repository.Employee_Details_Repo;
import com.example.Banking_Application.Bank_API_Service.Sign_Up_Details_Imple.Employee_Details_Imple;
import com.example.Banking_Application.DTO.DTO_Interfaces.EmployeeDetails;
import com.example.Banking_Application.DTO.Employee_Details_DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

@Service
public class Employee_Details_Service implements Employee_Details_Imple {

    @Autowired
    private Employee_Details_Repo employeeDetailsRepo;

    @Override
    public Employee_Details_Entity addEmployee(Employee_Details_Entity employeeDetailsEntity) throws Exception {
        try {

        }catch (Exception e)
        {
            throw  new Exception(e.getMessage());
        }
        return employeeDetailsRepo.save(employeeDetailsEntity);
    }

    @Override
    public List<Employee_Details_Entity> getAll() throws Exception {
        try {

        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
        return employeeDetailsRepo.findAll();
    }
    @Override
    public Optional<Employee_Details_Entity> getBy(String name) {
        return employeeDetailsRepo.findByName(name);
    }

    @Override
    public String deleteByIdEmp(Employee_Details_Entity id) throws Exception {
        try {
            employeeDetailsRepo.delete(id);
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
        return "Id Field Deleted Successfully";
    }
    @Override
    public LinkedHashMap<String, Object> updateEmpDetails(Employee_Details_DTO id) throws Exception {
        Employee_Details_Entity updateEmp =employeeDetailsRepo.updateEmpId(id.getId());
        LinkedHashMap<String,Object> linkedHashMap = null;
        try {
            if (employeeDetailsRepo.existsById(id.getId())){
            updateEmp.setEmployeeName(id.getEmployeeName());
            updateEmp.setEmployeeEmailID(id.getEmployeeEmailID());
            employeeDetailsRepo.save(updateEmp);
            linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.put("status", "Update Employee Details Successfully");
            linkedHashMap.put("data", new ArrayList<>());
            return linkedHashMap;
        }else {
                linkedHashMap = new LinkedHashMap<>();
                linkedHashMap.put("status", "Update Employee Details Successfully");
                linkedHashMap.put("data", new ArrayList<>());
                return linkedHashMap;
            }
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }
    @Override
    public LinkedHashMap<String, Object> updatePassword(Employee_Details_DTO name) throws Exception {
        Employee_Details_Entity updateEmpPassword = employeeDetailsRepo.updateEmpPassword(name.getEmployeeName());
        LinkedHashMap<String,Object> linkedHashMap1 =new LinkedHashMap<>();
        try {
    if(updateEmpPassword!=null){
        updateEmpPassword.setEmployeeEmailID(name.getEmployeeEmailID());
        employeeDetailsRepo.save(updateEmpPassword);
        linkedHashMap1 =new LinkedHashMap<>();
        linkedHashMap1.put("Message","EmailID Updated Successfully");
        linkedHashMap1.put( "data",new ArrayList<>());
        return linkedHashMap1;
    }else {
        linkedHashMap1 =new LinkedHashMap<>();
        linkedHashMap1.put("message","EmailId Update Failed");
        linkedHashMap1.put( "data",new ArrayList<>());
        return linkedHashMap1;
    }
}catch (Exception e){
    throw  new Exception(e.getMessage());
}
    }
    @Override
    public List<EmployeeDetails> getLocation(String name) throws Exception {
        List<EmployeeDetails> getall = employeeDetailsRepo.findAll(name);
        try{
            employeeDetailsRepo.findAll(name);
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
        return getall;
    }
}
