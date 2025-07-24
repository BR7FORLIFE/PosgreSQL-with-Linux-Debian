package com.notionconcept.notionconcept.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.notionconcept.notionconcept.auth.enums.Rol;
import com.notionconcept.notionconcept.interfaces.UserInterface;
import com.notionconcept.notionconcept.models.UserModel;

@Repository
public class UserRepository implements UserInterface{

    private final List<UserModel> users = new ArrayList<>(List.of(new UserModel("bryan", "123", Rol.ADMIN)));

    @Override
    public void saveUser(UserModel userModel){
        this.users.add(userModel);
    }    

    @Override
    public UserModel findbyUsername(String username){
        return this.users.stream().filter(user -> user.getUsername().equals(username)).findFirst().orElseThrow(() -> new UsernameNotFoundException("username not found!"));
    }

    public List<UserModel> getAllUsers(){
        return this.users;
    }
}
