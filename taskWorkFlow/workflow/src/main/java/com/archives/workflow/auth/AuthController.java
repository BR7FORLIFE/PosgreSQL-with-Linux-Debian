package com.archives.workflow.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.archives.workflow.auth.objectsAuth.RegisterAuth;

@RestController
@RequestMapping("/api")
public class AuthController {
    /**
     * ToDo
     * 
     * [x] create the endpoints for the differents unsafe url and safe url
     *
     */
    @PostMapping("/auth/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterAuth registerAuth) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body("User created succesfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User exits!");
        }
    }

    @PostMapping("/auth/login")
    public ResponseEntity<?> loginRegister(@RequestBody AuthenticationRequest loginAuth) {
        try {
            return ResponseEntity.status(HttpStatus.FOUND).body("Credential is correct!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Credential is not correct!");
        }
    }
}
