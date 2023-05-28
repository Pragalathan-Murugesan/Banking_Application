package com.example.Banking_Application.APIResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class APIResponse {
    private  Object status;
    private  Object error;
    private String message;
}
