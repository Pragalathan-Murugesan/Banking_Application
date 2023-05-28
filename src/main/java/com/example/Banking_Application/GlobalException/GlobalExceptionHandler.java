package com.example.Banking_Application.GlobalException;

import com.example.Banking_Application.APIResponse.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.HashMap;
import java.util.Map;
@RestControllerAdvice
public class GlobalExceptionHandler {
    @Autowired
    APIResponse apiResponseBody;
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public APIResponse handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);

            apiResponseBody.setStatus("error");
            apiResponseBody.setMessage("Invalid Request body");
            apiResponseBody.setError(errors);
        });
        return apiResponseBody;
    }
//    @ExceptionHandler(IllegalAccessException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public APIResponse exceptionHandler(IllegalAccessException e){
//        apiResponseBody.setError("Something Went To Wrong!");
//        apiResponseBody.setStatus("Error");
//        return apiResponseBody;
//    }
//    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public APIResponse exceptionHandler(Exception e){
//        Map<String, String> erro = new HashMap<>();
//            apiResponseBody.setError("Not Fount Exception!");
//            apiResponseBody.setStatus("Error");
//        return apiResponseBody;
//
//    }
}

