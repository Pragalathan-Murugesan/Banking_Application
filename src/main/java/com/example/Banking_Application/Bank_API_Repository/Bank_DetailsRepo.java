package com.example.Banking_Application.Bank_API_Repository;

import com.example.Banking_Application.Bank_API_Entity.Bank_Details_Entity;
import com.example.Banking_Application.Bank_API_Service.Sign_Up_Details_Imple.Bank_Details_DTO;
import com.example.Banking_Application.DTO.DTO_Interfaces.Bank_DetailsInter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Bank_DetailsRepo extends JpaRepository<Bank_Details_Entity,Long> {
@Query(value = "select * from bank_details where id = :id",nativeQuery = true)
    Bank_Details_Entity getByid(Long id);

    @Query(value = "select * from bank_details where id = :id",nativeQuery = true)
    Bank_Details_Entity update(Long id);

    @Query(value = "select * from bank_details where id = :id",nativeQuery = true)
    Bank_Details_Entity updateBy(Long id);
@Query(value = "select bank_details.id, bank_details.bank_manager_name, bank_details.bank_name, bank_details.bank_branches_name, loan_details.id, loan_details.customer_name, loan_details.loan_amount, loan_details.loan_name from bank_details Inner Join loan_details On bank_details.id = loan_details.id where bank_name = :name1",nativeQuery = true)
    List<Bank_DetailsInter> findAll(String name1);
}
