package com.geekymon2.carmarketplace.userservice.controller;

import com.geekymon2.carmarketplace.userservice.models.UserDto;
import com.geekymon2.carmarketplace.userservice.serviceimpl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@AutoConfigureTestDatabase
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application-test.yml")
class UserControllerIntegrationTest {
    private final UserController controller;

    @Autowired
    public UserControllerIntegrationTest(UserServiceImpl service, ModelMapper mapper) {
        this.controller = new UserController(service, mapper);
    }

    @Test
    void getStatus() {
    }

    @Test
    void getUsers() {
    }

    @Test
    void registerUserTest() {
        UserDto user = new UserDto();
        user.setFirstname("John");
        user.setLastname("Smith");
        user.setEmail("johnsmith@test.com");
        user.setPassword("password");
        Long id = controller.registerUser(user);
        assertNotNull(id);
    }
}