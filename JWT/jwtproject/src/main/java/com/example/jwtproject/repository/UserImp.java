package com.example.jwtproject.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.jwtproject.enums.Rol;
import com.example.jwtproject.interfaces.UserInterface;
import com.example.jwtproject.models.User;

@Repository
public class UserImp implements UserInterface{

    private List<User> users = List.of(new User("bryan", Rol.USER, "123"), new User("maria", Rol.ADMIN, "456"));
    
    @Override
    public List<User> getUsers() {
        return users;
    }
}
