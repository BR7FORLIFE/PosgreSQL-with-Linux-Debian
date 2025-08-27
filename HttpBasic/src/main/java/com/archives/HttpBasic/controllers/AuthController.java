package com.archives.HttpBasic.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    
    @GetMapping("/login")
    public ResponseEntity<String> login(Authentication authentication){
        return ResponseEntity.ok().body("Usuario registrado! " + authentication.getName() + authentication.getCredentials() + authentication.getAuthorities());
    }
}
