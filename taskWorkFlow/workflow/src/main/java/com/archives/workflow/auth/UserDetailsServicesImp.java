package com.archives.workflow.auth;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServicesImp implements UserDetailsService {
    // *esta clase ayudara para que el userDetails sepa como debe validar si un
    // usario registrado aparece en la base de datos */

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String query = "SELECT * FROM clients WHERE name = ?";

        try {
            return jdbcTemplate.queryForObject(query, new Object[] { username }, (ResultSet rs, int rowNum) -> new User(
                    rs.getString("name"),
                    rs.getString("password"),
                    List.of(new SimpleGrantedAuthority("ROLE_USER"))));
        } catch (UsernameNotFoundException e) {
            throw new UsernameNotFoundException("User not found: " + username);
        }
    }
}
