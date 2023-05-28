package com.example.Banking_Application.Bank_API_Repository;

import com.example.Banking_Application.Bank_API_Entity.Bank_Transaction_History_Entity;
import com.example.Banking_Application.DTO.Bank_Transaction_DTO;
import com.example.Banking_Application.DTO.DTO_Interfaces.Customer_Details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Bank_Transaction_History_Repo extends JpaRepository<Bank_Transaction_History_Entity,Long> {
    @Query(value = "select * from transaction_history where customer_name = :name",nativeQuery = true)
    Bank_Transaction_History_Entity getByName(String name);
    @Query(value = "select * from transaction_history where id = :id",nativeQuery = true)
    Bank_Transaction_History_Entity update(Long id);
    @Query(value = "select * from transaction_history where id = :id",nativeQuery = true)
    Bank_Transaction_History_Entity updateMin(Long id);
@Query(value = "select transaction_history.id,transaction_history.customer_name, transaction_history.min_transaction_amount,transaction_history.max_transaction_amount,customer_details.id, customer_details.customer_name,customer_details.customer_mobile_number,customer_details.customer_account_number from transaction_history Inner Join customer_details On transaction_history.customer_name = customer_details.customer_name where transaction_history.id = :id",nativeQuery = true)
    List<Customer_Details> findAll(Long id);
}