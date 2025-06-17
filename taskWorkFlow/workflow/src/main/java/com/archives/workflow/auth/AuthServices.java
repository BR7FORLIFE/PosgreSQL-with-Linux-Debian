package com.archives.workflow.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServices {
    // esta clase representa la informacion que digita el usuario (email, password)
    private final AuthenticationRequest authenticationRequest;
    private final PasswordEncoder passwordEncoder; // <-- para encriptar la contraseña
    private final JwtServices jwtServices; // <-- validar , generar JWT
    private final AuthenticationManager authenticationManager;

    public AuthServices(
            AuthenticationRequest authenticationRequest,
            PasswordEncoder passwordEncoder,
            JwtServices jwtServices,
            AuthenticationManager authenticationManager) {
        this.authenticationRequest = authenticationRequest;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtServices = jwtServices;
    }
}
