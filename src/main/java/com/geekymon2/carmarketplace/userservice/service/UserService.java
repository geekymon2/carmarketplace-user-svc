package com.geekymon2.carmarketplace.userservice.service;

import com.geekymon2.carmarketplace.userservice.entities.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    Long registerUser(User user);
    boolean validateUserPassword(String username, String password);
    boolean resetPassword();
    void updateUser(User car);
    Long getUsersCount();
}