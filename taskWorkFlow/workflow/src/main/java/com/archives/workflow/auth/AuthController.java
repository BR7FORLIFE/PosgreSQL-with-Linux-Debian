package com.archives.workflow.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.archives.workflow.auth.ObjectAuth.AuthenticationRequest;
import com.archives.workflow.auth.ObjectAuth.AuthenticationResponse;
import com.archives.workflow.auth.ObjectAuth.RegisterAuth;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private final AuthServices authServices;

    /**
     * ToDo
     * 
     * [x] create the endpoints for the differents unsafe url and safe url
     *
     */

    /**
     * 
     * @param registerAuth objeto que nos permite acceder al los campos del registro
     *                     del usuario
     * @return ResponseEntity<?>
     */
    @PostMapping("/auth/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterAuth registerAuth) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body("User created succesfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User exits!");
        }
    }

    /**
     * 
     * @param loginAuth AuthenticationRequest es una clase que nos
     * @return
     */
    @PostMapping("/auth/login")
    public ResponseEntity<AuthenticationResponse> loginUser(@RequestBody AuthenticationRequest request) {
        AuthenticationResponse response = authServices.login(request);
        return ResponseEntity.ok().body(response);
    }
}
