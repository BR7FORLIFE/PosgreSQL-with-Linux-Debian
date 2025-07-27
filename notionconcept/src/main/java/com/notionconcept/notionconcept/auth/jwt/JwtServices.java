package com.notionconcept.notionconcept.auth.jwt;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.notionconcept.notionconcept.models.UserModel;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JwtServices {

    @Value("${jwt.secret.key}")
    private final String SECREY_KEY;

    private SecretKey key;

    @PostConstruct
    public void init() {
        this.key = Keys.hmacShaKeyFor(SECREY_KEY.getBytes(StandardCharsets.UTF_8));
    }

    public String generateToken(UserModel userModel) {
        Instant at = Instant.now();
        Instant expiration = at.plusSeconds(3600);

        Date atDate = Date.from(at);
        Date expirationTime = Date.from(expiration);

        return Jwts.builder()
                .claim("rol", userModel.getRol())
                .subject(userModel.getUsername())
                .signWith(key)
                .issuedAt(atDate)
                .expiration(expirationTime)
                .compact();
    }

    private Claims extractALlClaims(String token) {
        try {
            JwtParser parser = Jwts.parser().verifyWith(key).build();
            return parser.parseSignedClaims(token).getPayload();

        } catch (JwtException | IllegalArgumentException e) {
            throw new JwtException("jwt key invalid!");
        }
    }

    public boolean isValidToken(String token, UserDetails userDetails) {
        final String payloadJwt = extractALlClaims(token).getSubject();
        String username = userDetails.getUsername();
        return (payloadJwt.equals(String.valueOf(username))) && !isTokenExpired(token);
    }

    public String extractUsername(String token) {
        return extractALlClaims(token).getSubject();
    }

    public String extractRol(String token) {
        return extractALlClaims(token).get("rol", String.class);
    }

    public boolean isTokenExpired(String token) {
        return extractALlClaims(token).getExpiration().before(new Date());
    }

}
