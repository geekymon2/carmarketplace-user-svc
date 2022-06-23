package com.geekymon2.carmarketplace.userservice.serviceimpl;

import com.geekymon2.carmarketplace.userservice.entities.User;
import com.geekymon2.carmarketplace.userservice.repository.UserRepository;
import com.geekymon2.carmarketplace.userservice.service.UserService;
import com.geekymon2.carmarketplace.userservice.validation.UserValidator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserValidator validator;

    public UserServiceImpl(UserRepository repository, UserValidator validator) {
        this.repository = repository;
        this.validator = validator;
    }

    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        repository.findAll().forEach(users::add);
        return users;
    }

    @Override
    public Long registerUser(User user) {
        validator.validateUser(user);
        return repository.save(user).getId();
    }

    @Override
    public boolean validateUserPassword() {
        return false;
    }

    @Override
    public boolean resetPassword() {
        return false;
    }

    @Override
    public void updateUser(User user) {
        repository.save(user);
    }

    @Override
    public Long getUsersCount() {
        return repository.count();
    }
}
