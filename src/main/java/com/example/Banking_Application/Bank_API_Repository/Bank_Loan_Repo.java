package com.example.Banking_Application.Bank_API_Repository;

import com.example.Banking_Application.Bank_API_Entity.Bank_Loan_Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Bank_Loan_Repo extends JpaRepository<Bank_Loan_Entity,Long> {

    @Query(value = "select * from loan_details where customer_name = :name",nativeQuery = true)
    Bank_Loan_Entity getByName(String name);

    @Query(value = "select * from loan_details where id = :id",nativeQuery = true)
    Bank_Loan_Entity updateall(Long id);

    @Query(value = "select * from loan_details where id = :id",nativeQuery = true)
    Bank_Loan_Entity updatename(Long id);
}
