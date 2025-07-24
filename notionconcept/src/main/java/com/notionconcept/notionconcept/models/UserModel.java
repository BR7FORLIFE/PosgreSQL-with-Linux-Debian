package com.notionconcept.notionconcept.models;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.notionconcept.notionconcept.auth.enums.Rol;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserModel implements UserDetails{

    private final String username;
    private final String password;
    private final Rol rol;
    private List<Rol> rols;

    @Override
    public String getPassword(){
        return this.password;
 
    }

    @Override
    public String getUsername(){
        return this.username;
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return rols.stream().map(rol -> new SimpleGrantedAuthority("ROLE_" + rol.name())).collect(Collectors.toList());
    }

    public Rol getRol(){
        return this.rol;
    }
}
