package com.geekymon2.carmarketplace.userservice.service;

import com.geekymon2.carmarketplace.userservice.entities.AppUser;

import java.util.List;

public interface UserService {
    List<AppUser> getUsers();
    Long registerUser(AppUser user);
    boolean validateUserPassword(String username, String password);
    boolean resetPassword();
    void updateUser(AppUser car);
    Long getUsersCount();
}