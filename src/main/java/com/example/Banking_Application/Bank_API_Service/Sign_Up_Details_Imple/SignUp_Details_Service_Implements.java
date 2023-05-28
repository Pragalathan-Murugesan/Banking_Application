package com.example.Banking_Application.Bank_API_Service.Sign_Up_Details_Imple;

import com.example.Banking_Application.APIResponse.APIResponse;
import com.example.Banking_Application.Bank_API_Entity.SignUp_Details_Entity;
import com.example.Banking_Application.DTO.SignUpDetailsDTO;
import org.springframework.http.ResponseEntity;

import java.util.LinkedHashMap;
import java.util.List;

public interface SignUp_Details_Service_Implements {
//    SignUp_Details_Entity addUser(SignUp_Details_Entity signUpDetailsEntity) ;

    List<SignUp_Details_Entity> getAll() throws Exception;

    APIResponse getById(SignUpDetailsDTO name) ;

    String deleteId(SignUp_Details_Entity id) throws Exception;

    SignUp_Details_Entity updateAll(String name);

    LinkedHashMap updateByPassword(Long id) throws Exception;

    LinkedHashMap<String,Object> updateSign(SignUpDetailsDTO id) throws Exception;

  APIResponse addUser(SignUpDetailsDTO signUpDetailsDTO);
}
