package com.archives.workflow.auth.jwt;

import java.time.Instant;
import java.util.Date;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtServices {
    private final String signatureJWString = "br7forlife_firma_secret_proyecto";// <-- secret key for json web token

    public String generateToken(UserDetails userDetails) { // <-- generate json web token
        Instant instant = Instant.now();

        return Jwts.builder()
                .subject(userDetails.getUsername())
                .issuedAt(Date.from(instant))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(Keys.hmacShaKeyFor(signatureJWString.getBytes()), SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractJsonWebToken(String token) { // <-- extract json web token
        return null;
    }

    public boolean isTokenValid(String token, UserDetails userDetails) { // <-- valid the token for the user
        return false;
    }

    private boolean isTokenExpired(String token) { // verified the token expired
        return false;
    }

    private Claims extractAllClaims(String token) { // decode json web token and extract information for user
        return null;
    }
}
