package com.example.Banking_Application.Bank_API_Repository;

import com.example.Banking_Application.Bank_API_Entity.Customer_Details_Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Customer_Details_Repo extends JpaRepository<Customer_Details_Entity,Long> {
    @Query(value = "select * from customer_details where customer_name=:name",nativeQuery = true)
    Customer_Details_Entity findByName(String name);

    @Query(value = "select * from customer_details where id=:id",nativeQuery = true)
    Customer_Details_Entity updateCustomer(Long id);

    @Query(value = "select * from customer_details where id=:id",nativeQuery = true)
    Customer_Details_Entity updateName(Long id);
}
