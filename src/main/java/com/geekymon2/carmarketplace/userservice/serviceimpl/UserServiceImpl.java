package com.geekymon2.carmarketplace.userservice.serviceimpl;

import com.geekymon2.carmarketplace.userservice.entities.User;
import com.geekymon2.carmarketplace.userservice.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public Long registerUser(User user) {
        return null;
    }

    @Override
    public boolean validateUser() {
        return false;
    }

    @Override
    public void updateUser(User car) {

    }

    @Override
    public Long getUsersCount() {

        return null;
    }
}
