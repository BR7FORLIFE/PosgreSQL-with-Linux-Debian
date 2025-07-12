package com.example.jwtproject.repository;

import java.util.List;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.example.jwtproject.enums.Rol;
import com.example.jwtproject.interfaces.UserInterface;
import com.example.jwtproject.models.UserModel;

@Repository
public class UserRepositoryImp implements UserInterface{

    private List<UserModel> users = List.of(new UserModel("bryan", Rol.USER, "123"), new UserModel("maria", Rol.ADMIN, "456"));
    
    @Override 
    public UserModel saveUser(UserModel userModel){
        users.add(userModel);
        return userModel;
    }

    @Override
    public List<UserModel> getUsers() {
        return users;
    }

    @Override
    public UserModel findUserByUsername(String username) {
       return users.stream().filter(user -> user.equals(username)).findFirst().orElseThrow(() -> new UsernameNotFoundException("username not found!"));
    }
}
