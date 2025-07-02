package com.archives.workflow.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.archives.workflow.auth.ObjectAuth.AuthenticationRequest;
import com.archives.workflow.auth.ObjectAuth.AuthenticationResponse;
import com.archives.workflow.auth.ObjectAuth.RegisterAuth;
import com.archives.workflow.auth.jwt.JwtServices;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServices {

    /*
     * (spring security) <-- esto es una interfaz que permite autenticar a un
     * usuario segun la request que decidas ejemplo usuario y contraseña
     */
    private final AuthenticationManager authenticationManager;

    /*
     * <--(clase propia) esto permite acceder a los diferentes servicios de
     * jwtServices como el generar el jwt para el usuario
     */
    private final JwtServices jwtServices;

    /*
     * <-- interfaz que permite cargar un usuario en la base de datos para validar
     * que de vd este registrado OJO para que pueda hacer esa magia es necesario
     * crear un clase que herede d euserDetailsServices y definir ahi como lo va a
     * hacer como un rowmapper
     */
    private final UserDetailsService userDetailsService;

    public void register(RegisterAuth request) {

    }

    public AuthenticationResponse login(AuthenticationRequest request) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUser(), request.getPassword()));

        UserDetails user = userDetailsService.loadUserByUsername(request.getUser());
        String jwt = jwtServices.generateToken(user);

        return new AuthenticationResponse(jwt);
    }
}
