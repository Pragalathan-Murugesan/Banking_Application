package com.example.Banking_Application.GlobalException;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BadRequestException extends RuntimeException {
    private List<Error> errors;

}
