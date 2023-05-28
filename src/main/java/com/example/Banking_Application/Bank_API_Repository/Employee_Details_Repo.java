package com.example.Banking_Application.Bank_API_Repository;

import com.example.Banking_Application.Bank_API_Entity.Employee_Details_Entity;
import com.example.Banking_Application.DTO.DTO_Interfaces.EmployeeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface Employee_Details_Repo extends JpaRepository<Employee_Details_Entity,Long> {
    @Query(value = "select * from employee_details where employee_name=:name",nativeQuery = true)
    Optional<Employee_Details_Entity> findByName(String name);

    @Query(value = "select * from employee_details where id=:id",nativeQuery = true)
    Employee_Details_Entity updateEmpId(Long id);

    @Query(value = "select * from employee_details where employee_name=:employeeName",nativeQuery = true)
    Employee_Details_Entity updateEmpPassword(String employeeName);
    @Query(value = "select * from employee_details where employee_name=:employeeName",nativeQuery = true)
    String findByEmployeeName(String employeeName);

//    @Query(value = " select id, employee_name, employee_mobile_number from employee_details where id = :id",nativeQuery = true)
//    List<Employee_Details_Entity> getDetails(Long id);
//   @Query(value = " select employee_details.id, employee_name, employee_mobile_number, locationh,employee_emailid from employee_details where id = :mobile",nativeQuery = true)
//    List<EmployeeDetails> findAll(Long mobile);

   @Query(value = "select employee_details.id, employee_details.employee_name, employee_details.locationh,employee_emailid, sign_up_details.location, sign_up_details.emailid, sign_up_details.first_name from employee_details Inner Join sign_up_details On employee_details.locationh = sign_up_details.location where employee_name = :name",nativeQuery = true)
    List<EmployeeDetails> findAll(String name);
}