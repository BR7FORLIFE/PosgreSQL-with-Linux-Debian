package com.example.jwtproject.models;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.jwtproject.enums.Rol;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User implements UserDetails {
    private String name;
    private Rol rol;
    private String password;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return List.of(new SimpleGrantedAuthority("ROLE" + rol.name()));
    }

    @Override
    public String getPassword(){
        return password;
    }

    @Override
    public String getUsername(){
        return name;
    }
}
