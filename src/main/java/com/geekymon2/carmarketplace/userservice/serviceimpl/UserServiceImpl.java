package com.geekymon2.carmarketplace.userservice.serviceimpl;

import com.geekymon2.carmarketplace.core.exception.InvalidParameterException;
import com.geekymon2.carmarketplace.userservice.entities.AppUser;
import com.geekymon2.carmarketplace.userservice.repository.UserRepository;
import com.geekymon2.carmarketplace.userservice.service.UserService;
import com.geekymon2.carmarketplace.userservice.validation.UserValidator;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
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
    public List<AppUser> getUsers() {
        List<AppUser> users = new ArrayList<>();
        repository.findAll().forEach(users::add);
        return users;
    }

    @Override
    public Long registerUser(AppUser user) {
        if (repository.findByEmail(user.getEmail()) != null) {
            throw new InvalidParameterException("Email already exists.");
        }

        validator.validateUser(user);
        user.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        return repository.save(user).getId();
    }

    @Override
    public boolean validateUserPassword(String email, String password) {
        AppUser user = repository.findByUsernameAndPassword(email, password);
        return user != null;
    }

    @Override
    public boolean resetPassword() {
        return false;
    }

    @Override
    public void updateUser(AppUser user) {
        repository.save(user);
    }

    @Override
    public Long getUsersCount() {
        return repository.count();
    }

    @Override
    public boolean checkEmailExists(String email) {
        return repository.findByEmail(email) != null;
    }
}
