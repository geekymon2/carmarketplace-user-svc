package com.geekymon2.carmarketplace.userservice.controller;

import com.geekymon2.carmarketplace.core.exception.RecordNotFoundException;

import com.geekymon2.carmarketplace.userservice.serviceimpl.UserServiceImpl;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ValidateResetPasswordTest {


    // Valid email returns the same email
    @Test
    public void test_valid_email_returns_same_email() {
        UserServiceImpl service = mock(UserServiceImpl.class);
        ModelMapper mapper = mock(ModelMapper.class);
        UserController controller = new UserController(service, mapper);
        String email = "test@example.com";
    
        when(service.validateResetPassword(email)).thenReturn(email);
    
        String result = controller.validateResetPassword(email);
    
        assertEquals(email, result);
        verify(service).validateResetPassword(email);
    }

    // Email does not exist in the repository
    @Test
    public void test_email_does_not_exist_in_repository() {
        UserServiceImpl service = mock(UserServiceImpl.class);
        ModelMapper mapper = mock(ModelMapper.class);
        UserController controller = new UserController(service, mapper);
        String email = "nonexistent@example.com";
    
        when(service.validateResetPassword(email)).thenThrow(new RecordNotFoundException("Invalid email id. Please register using the registration link."));
    
        assertThrows(RecordNotFoundException.class, () -> controller.validateResetPassword(email));
    
        verify(service).validateResetPassword(email);
    }
}