package com.notionconcept.notionconcept.interfaces;

import com.notionconcept.notionconcept.models.UserModel;

public interface UserInterface {
    void saveUser(UserModel userModel);
    UserModel findbyUsername(String username);
}
