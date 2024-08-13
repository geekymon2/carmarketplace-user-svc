package com.geekymon2.carmarketplace.userservice.validation;

import com.geekymon2.carmarketplace.core.exception.InvalidParameterException;
import com.geekymon2.carmarketplace.core.exception.MandatoryParamMissingException;
import com.geekymon2.carmarketplace.userservice.entities.AppUser;

public class UserValidator {
    public void validateUser(AppUser user) {
        if (user.getFirstname() == null || user.getFirstname().isBlank()) {
            throw new MandatoryParamMissingException("Firstname is required.");
        }

        if (user.getLastname() == null || user.getLastname().isBlank()) {
            throw new MandatoryParamMissingException("Lastname is required.");
        }

        if (user.getEmail() == null || user.getEmail().isBlank()) {
            throw new MandatoryParamMissingException("Email is required.");
        }

        if (user.getPassword() == null || user.getPassword().isBlank()) {
            throw new MandatoryParamMissingException("Password is required.");
        }

        if (validateEmailFormat(user.getEmail())) {
            throw new MandatoryParamMissingException("Email format is incorrect.");
        }
    }

    private boolean validateEmailFormat(String email) {
        return !email.matches("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$");
    }
}
