package com.notionconcept.notionconcept.auth.DTOS;

import java.util.UUID;

import com.notionconcept.notionconcept.auth.enums.Rol;

import lombok.Data;

@Data
public class AuthenticationRequest {
    public final UUID user_id;
    public final String name;
    public final String password;
    public final Rol rol;
}
