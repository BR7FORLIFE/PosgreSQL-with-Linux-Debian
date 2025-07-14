package com.example.jwtproject.auth.jwt;


import java.security.Key;
import java.time.Instant;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.jwtproject.models.UserModel;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JwtServices {
    
    @Value("${jwt.secret.key}")
    private String SECRET_KEY;

    public String generateToken(UserModel userModel){
        //esto nos permite tomar el secret key y decoficarlo a bytes (256 bit - 32 caracteres) y usarlo como firma
        // o signature del json web token
        Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes()); 

        //timepo actual y timepo de expiracion
        Instant instant = Instant.now();
        Instant expiration = instant.plusSeconds(3600);

        Date issueAt = Date.from(instant);
        Date expirationTime = Date.from(expiration);

        
        return Jwts.builder()
                   .claim("rol", userModel.getRol())
                   .subject(String.valueOf(userModel.getId()))
                   .issuedAt(issueAt)
                   .expiration(expirationTime)
                   .signWith(key)
                   .compact();
    }

    public String extractUsername(String token){
        return null;
    }

    private Claims extractAllClaims(String token){
        return null;
    }

    public boolean isValidToken(){
        return false;
    }
}
