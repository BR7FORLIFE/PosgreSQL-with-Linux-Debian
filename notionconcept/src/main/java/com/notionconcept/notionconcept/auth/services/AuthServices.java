package com.notionconcept.notionconcept.auth.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.notionconcept.notionconcept.auth.DTOS.AuthenticationRequest;
import com.notionconcept.notionconcept.auth.DTOS.AuthenticationResponse;
import com.notionconcept.notionconcept.auth.jwt.JwtServices;
import com.notionconcept.notionconcept.models.UserModel;
import com.notionconcept.notionconcept.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServices {

    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtServices jwtServices;

    public AuthenticationResponse register(AuthenticationRequest request) {
        UserModel userEncryting = new UserModel(request.getName(), passwordEncoder.encode(request.getPassword()),
                request.getRol());

        userRepository.saveUser(userEncryting);
        // aca generamos el jwt para el usuario!
        String token = null;
        return new AuthenticationResponse(token);
    }

    public AuthenticationResponse login(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getName(), request.getPassword()));
        UserModel user = userRepository.findbyUsername(request.name);

        // aca generamos el jwt para el usuario!
        String token = null;

        return new AuthenticationResponse(token);
    }
}
