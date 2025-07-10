package com.example.jwtproject.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.jwtproject.interfaces.UserInterface;
import com.example.jwtproject.models.User;
import com.example.jwtproject.repository.UserImp;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserServices implements UserInterface{
    private final UserImp userImp;

    @Override
    public List<User> getUsers(){
        return userImp.getUsers();
    }    
}
