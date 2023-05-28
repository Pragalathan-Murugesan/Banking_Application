package com.example.Banking_Application.Bank_API_Controller;

import com.example.Banking_Application.APIResponse.APIResponse;
import com.example.Banking_Application.Bank_API_Entity.SignUp_Details_Entity;
import com.example.Banking_Application.Bank_API_Service.Sign_Up_Details_Imple.SignUp_Details_Service_Implements;
import com.example.Banking_Application.DTO.SignUpDetailsDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
@RestController
@RequestMapping("/signup")
public class SignUp_Details_Controller {
    @Autowired
    private SignUp_Details_Service_Implements signUpDetailsService;
    @PostMapping(value = "/adduser")
    public APIResponse addUser(@RequestBody @Valid SignUpDetailsDTO signUpDetailsDTO) {
        return signUpDetailsService.addUser(signUpDetailsDTO);
    }
    @GetMapping(value = "/getall")
    public List<SignUp_Details_Entity> getAll() throws Exception {
        return signUpDetailsService.getAll();
    }
    @GetMapping(value = "/getbyid")
    public APIResponse getById(@RequestBody SignUpDetailsDTO name)  {
        return signUpDetailsService.getById(name);
    }
    @DeleteMapping(value = "/deleteid/{id}")
    public String deleteId(@PathVariable("id") SignUp_Details_Entity id) throws Exception {
        return signUpDetailsService.deleteId(id);
    }

    @PutMapping(value = "/update/{name}")
    public SignUp_Details_Entity updateAll(@PathVariable("name") String name){
        return signUpDetailsService.updateAll(name);
    }
    @PatchMapping(value = "/updatebypassword/{id}")
    public LinkedHashMap updateByPassword(@PathVariable("id") Long id) throws Exception {
        return signUpDetailsService.updateByPassword(id);
    }

    @PutMapping(value = "/updatesign")
    public LinkedHashMap<String,Object> updateSign(@RequestBody SignUpDetailsDTO id) throws Exception {
        return signUpDetailsService.updateSign(id);
    }
    }
