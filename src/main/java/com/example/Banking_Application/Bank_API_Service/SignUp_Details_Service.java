package com.example.Banking_Application.Bank_API_Service;

import com.example.Banking_Application.APIResponse.APIResponse;
import com.example.Banking_Application.Bank_API_Entity.SignUp_Details_Entity;
import com.example.Banking_Application.Bank_API_Repository.SignUp_Details_Repo;
import com.example.Banking_Application.Bank_API_Service.Sign_Up_Details_Imple.SignUp_Details_Service_Implements;
import com.example.Banking_Application.DTO.SignUpDetailsDTO;
import com.example.Banking_Application.JWTUtillity.JWTUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
@Service
public class SignUp_Details_Service implements SignUp_Details_Service_Implements {
    @Autowired
    private SignUp_Details_Repo signUpDetailsRepo;

    @Autowired
    private JWTUtility jwtUtility;

    @Override
    public APIResponse addUser(SignUpDetailsDTO signUpDetailsDTO) {
        APIResponse apiResponse = new APIResponse();
//       SignUpDetailsDTO addd = new SignUpDetailsDTO();
//       addd.setId(signUpDetailsDTO.getId());
//       addd.setFirstName(signUpDetailsDTO.getFirstName());
//       addd.setLastName(signUpDetailsDTO.getLastName());
//       addd.setEmailID(signUpDetailsDTO.getEmailID());
//       addd.setMobileNumber(signUpDetailsDTO.getMobileNumber());
////       addd.setLocation(signUpDetailsDTO.getLocation());
//       addd.setPassword(signUpDetailsDTO.getPassword());

        String token= jwtUtility.generateTokens(new SignUp_Details_Entity());
        apiResponse.setStatus(token);
        apiResponse.setMessage("success");

               return apiResponse;
    }
    @Override
    public List<SignUp_Details_Entity> getAll() throws Exception {
        try {
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return signUpDetailsRepo.findAll();
    }
    @Override
    public APIResponse getById(SignUpDetailsDTO name) {
        APIResponse apiResponse = new APIResponse();

           SignUp_Details_Entity get= signUpDetailsRepo.getByName(name);
             String token= jwtUtility.generateTokens(new SignUp_Details_Entity());
                apiResponse.setStatus(token);
        return apiResponse;
    }

    @Override
    public String deleteId(SignUp_Details_Entity id) throws Exception {
        try {
            signUpDetailsRepo.delete(id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return "Deleted Successfully";
    }

    @Override
    public SignUp_Details_Entity updateAll(String name) {
        SignUp_Details_Entity update = signUpDetailsRepo.updateByName(name);
        System.out.println(update);
        update.setFirstName("ff");
        update.setLastName("name");
        update.setEmailID("872@gmail.com");
//        update.setPassword(567890343L);
//        update.setMobileNumber(345678909L);
        return signUpDetailsRepo.save(update);
    }
    @Override
    public LinkedHashMap updateByPassword(Long id) throws Exception {
        SignUp_Details_Entity updatepassword = signUpDetailsRepo.updatePassword(id);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            if (signUpDetailsRepo.existsById(id)) {
                signUpDetailsRepo.updatePassword(id);
//                 updatepassword.setPassword(34567890987L);
                linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("status", "updated Successfully");
                linkedHashMap.put("data", signUpDetailsRepo.save(updatepassword));
                return linkedHashMap;
            } else {
                linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("status", "Updated Failed");
                linkedHashMap.put("data", signUpDetailsRepo.save(updatepassword));
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return linkedHashMap;
    }

    @Override
    public LinkedHashMap<String, Object> updateSign(SignUpDetailsDTO id) throws Exception {
        SignUp_Details_Entity updateSignUp = signUpDetailsRepo.updateSignU(id.getId());
        String frrstName = signUpDetailsRepo.findByFristName(id.getFirstName());
        LinkedHashMap<String, Object> linkedHashMap = null;
        if (frrstName.equals(id.getFirstName())) {
            System.out.println("hi");
        } else {
            System.out.println("bye");
        }
        try {
            if (signUpDetailsRepo.existsById(id.getId())) {
                updateSignUp.setFirstName(id.getFirstName());
                updateSignUp.setLastName(id.getLastName());
//                updateSignUp.setPassword(34567898765L);
                signUpDetailsRepo.save(updateSignUp);
                linkedHashMap = new LinkedHashMap<>();
                linkedHashMap.put("status", "success");
                linkedHashMap.put("message", "Account updated successfully");
                linkedHashMap.put("data", new ArrayList<>());
                return linkedHashMap;
            } else {
                linkedHashMap = new LinkedHashMap<>();
                linkedHashMap.put("status", "error");
                linkedHashMap.put("message", "Invalid account id");
                linkedHashMap.put("data", frrstName);
                return linkedHashMap;
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
