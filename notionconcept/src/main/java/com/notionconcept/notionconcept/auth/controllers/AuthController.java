package com.notionconcept.notionconcept.auth.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notionconcept.notionconcept.auth.DTOS.AuthenticationRequest;
import com.notionconcept.notionconcept.auth.DTOS.AuthenticationResponse;
import com.notionconcept.notionconcept.auth.services.AuthServices;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthServices authServices;

    @GetMapping("/register")
    public ResponseEntity<AuthenticationResponse> reguster(@RequestBody AuthenticationRequest request){
        AuthenticationResponse response = authServices.register(request);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request){
        AuthenticationResponse response = authServices.login(request);
        return ResponseEntity.ok().body(response);
    }
}
