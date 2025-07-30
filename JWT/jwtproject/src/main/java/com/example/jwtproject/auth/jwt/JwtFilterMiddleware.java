package com.example.jwtproject.auth.jwt;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtFilterMiddleware extends OncePerRequestFilter {

    private final JwtServices jwtServices;
    private final UserDetailsService userDetailsService;
    
    @SuppressWarnings("null")
    @Override
    protected void doFilterInternal(
            HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException, java.io.IOException {

        final String headerAuthorization = request.getHeader("Authorization");
        final String jwtToken;
        final String username; 

        if(headerAuthorization == null || !headerAuthorization.startsWith("Bearer ")){
            filterChain.doFilter(request, response);
            return;
        }

        System.out.println(headerAuthorization);

        jwtToken = headerAuthorization.substring(7);
        username = jwtServices.extractIdUsername(jwtToken);

        if(username == null || SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            if(jwtServices.isValidToken(jwtToken, userDetails)){
                UsernamePasswordAuthenticationToken authTokenUser = new UsernamePasswordAuthenticationToken(username, null, userDetails.getAuthorities());

                SecurityContextHolder.getContext().setAuthentication(authTokenUser);
            }
        }
        
    }
}
