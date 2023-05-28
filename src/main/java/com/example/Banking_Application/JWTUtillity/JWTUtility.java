package com.example.Banking_Application.JWTUtillity;

import com.example.Banking_Application.Bank_API_Entity.SignUp_Details_Entity;
import com.example.Banking_Application.DTO.SignUpDetailsDTO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.persistence.Column;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTUtility {

    private  static  final String  secretKey = "web APP hhhhPort";
    private static Long expiredDuration = (long) (60 * 60);
    Long takenAt = System.currentTimeMillis();
    Long expiredDate = takenAt + expiredDuration *1000;
    Date issuedAt = new Date(takenAt);
    Date expiredAt =new Date(expiredDate);

    public  String generateTokens(SignUp_Details_Entity signUpDetailsEntity){

        Claims claims = Jwts.claims().setIssuer(signUpDetailsEntity
                .getFirstName())
                .setIssuedAt(issuedAt).setExpiration(expiredAt);

        claims.put("id",signUpDetailsEntity.getId());
        claims.put("firstName",signUpDetailsEntity.getFirstName());
        claims.put("emailId",signUpDetailsEntity.getEmailID());
        claims.put("mobileNumber",signUpDetailsEntity.getMobileNumber());
           return  Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS256,"web APP hhhhPort").compact();
    }
}
