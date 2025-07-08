package com.archives.workflow.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    // private final JwtAuthenticationFilter jwtAuthFilter;
    private final UserDetailsService userDetailsService;
    private final JwtFilterMiddleware jwtFilterMiddleware;

    /**
     * 
     * @param httpSecurity
     * @return
     * @throws Exception
     */

    /* SecurityFilterChain - Define qué rutas están protegidas y qué filtros usar */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        /**
         * orden de como se debe concatenar los metodos para una buena configuracion
         * 1 - .csrf()
         * 
         * 2 - .authorizeHttpRequests()
         * 
         * 3 - .sessionManagement()
         * 
         * 4 - .authenticationProvider()
         * 
         * 5 - .addFilterBefore(...)
         * 
         * 6 - .build()
         */
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/**").permitAll() // <-- permite login y registro sin token
                        .anyRequest().authenticated())
                .sessionManagement(sess -> sess
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // <-- no sesiones
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(jwtFilterMiddleware, UsernamePasswordAuthenticationFilter.class) // <-- JWT primero
                .build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder()); // <-- Para validar la contraseña correctamente
        return provider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager(); // <-- Usado en AuthServices
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // <-- Nunca guardes contraseñas planas
    }
    // nota! cuando se retorna una clase se usa el nombre del metodo ejemplo:

    /*
     * public Persona crearPersona(String nombre) {
     * return new Persona(nombre);
     * }
     * 
     * public Persona crearPersona(String nombre) {
     * return new Persona(nombre);
     * }
     */
}