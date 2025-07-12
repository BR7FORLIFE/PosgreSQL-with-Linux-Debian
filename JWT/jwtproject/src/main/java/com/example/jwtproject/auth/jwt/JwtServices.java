package com.example.jwtproject.auth.jwt;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JwtServices {
    
    private final String secretKey;


    public String generateToken(UserDetails userDetails){
        return null;
    }

    public boolean isValidToken(){
        return false;
    }
}
