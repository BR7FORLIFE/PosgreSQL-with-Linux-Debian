package com.example.jwtproject.auth.jwt;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.jwtproject.models.UserModel;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JwtServices {

    @Value("${jwt.secret.key}")
    private String SECRET_KEY;

    // esto nos permite tomar el secret key y decoficarlo a bytes (256 bit - 32
    // caracteres) y usarlo como firma
    // o signature del json web token
    private SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));

    public String generateToken(UserModel userModel) {

        // timepo actual y timepo de expiracion
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

    private Claims extractAllClaims(String token) {
        JwtParser parser =  Jwts.parser().verifyWith(key).build();
        return parser.parseSignedClaims(token).getPayload();
    }

    public boolean isValidToken(String token, UserDetails userDetails) {
        final String username = extractAllClaims(token).getSubject();
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    public String extractIDUsername(String token){
        return extractAllClaims(token).getSubject();
    } 

    public String extractRol(String token){
        return extractAllClaims(token).get("rol", String.class);
    }

    public boolean isTokenExpired(String token){
        return extractAllClaims(token).getExpiration().before(new Date());
    }
}
