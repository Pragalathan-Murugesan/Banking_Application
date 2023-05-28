package com.example.Banking_Application.Bank_API_Repository;

import com.example.Banking_Application.Bank_API_Entity.SignUp_Details_Entity;
import com.example.Banking_Application.DTO.SignUpDetailsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SignUp_Details_Repo extends JpaRepository<SignUp_Details_Entity, Long> {

    @Query(value = "select * from sign_up_details where first_name=:name",nativeQuery = true)
    SignUp_Details_Entity getByName(SignUpDetailsDTO name);

    @Query(value = "select * from sign_up_details where first_name =: name",nativeQuery = true)
    SignUp_Details_Entity updateByName(String name);

    @Query(value = "select * from sign_up_details where id=:id",nativeQuery = true)
    SignUp_Details_Entity updateSignU(long id);

    @Query(value = "select sign_up_details.first_name from sign_up_details where sign_up_details.first_name=:firstName",nativeQuery = true)
    String findByFristName(String firstName);

        @Query(value = "select * from sign_up_details where id=:id",nativeQuery = true)
    SignUp_Details_Entity updatePassword(Long id);

}
