package com.spring.spring_example.middlewares;

import java.io.IOException;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.spring.spring_example.security.Jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtMiddleware extends OncePerRequestFilter {

    private final UserDetailsService userDetailsService;
    private final Jwt jwt;

    @SuppressWarnings("null")
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
        //constantes
        final String authenticationToken;
        final String jwtToken;
        final String username;

        authenticationToken = request.getHeader("Authorization");
        
        
    }

}
