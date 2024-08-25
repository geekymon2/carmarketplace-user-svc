package com.geekymon2.carmarketplace.userservice.service;

import com.geekymon2.carmarketplace.userservice.entities.AppUser;

import java.util.List;

public interface UserService {
    List<AppUser> getUsers();
    Long registerUser(AppUser user);
    boolean validateUserPassword(String username, String password);
    String validateEmail(String email);
    void updateUser(AppUser car);
    Long getUsersCount();
    boolean checkEmailExists(String email);
}