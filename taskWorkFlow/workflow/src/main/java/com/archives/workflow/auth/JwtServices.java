package com.archives.workflow.auth;

import org.springframework.stereotype.Component;

import com.archives.workflow.auth.objectsAuth.RegisterAuth;

import io.jsonwebtoken.Claims;

@Component
public class JwtServices {
    // <-- secret key for json web token

    public String generateToken(RegisterAuth registerAuth) { // <-- generate json web token
        return null;
    }

    public String extractJsonWebToken(String token) { // <-- extract json web token
        return null;
    }

    public boolean isTokenValid(String token, RegisterAuth registerAuth) { // <-- valid the token for the user
        return false;
    }

    private boolean isTokenExpired(String token) { // verified the token expired
        return false;
    }

    private Claims extractAllClaims(String token) { // decode json web token and extract information for user
        return null;
    }
}
