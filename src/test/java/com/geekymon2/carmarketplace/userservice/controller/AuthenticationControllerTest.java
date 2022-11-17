package com.geekymon2.carmarketplace.userservice.controller;

import com.geekymon2.carmarketplace.core.autoconfiguration.security.jwt.JwtTokenUtil;
import com.geekymon2.carmarketplace.core.autoconfiguration.security.properties.JwtConfig;
import com.geekymon2.carmarketplace.userservice.models.JwtRequestDto;
import com.geekymon2.carmarketplace.userservice.service.UserService;
import com.geekymon2.carmarketplace.userservice.serviceimpl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureTestDatabase
@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
@TestPropertySource(locations = "classpath:application-test.yml")
@Slf4j
class AuthenticationControllerTest {
    @Mock
    private JwtConfig config;
    private AuthenticationController controller;
    private final UserServiceImpl service;

    @Autowired
    public AuthenticationControllerTest(UserServiceImpl service) {
        this.service = service;
    }

    @BeforeEach
    void init() {
        log.info("Before Each Test: Init");
        JwtTokenUtil tokenUtil = new JwtTokenUtil(config);
        this.controller = new AuthenticationController(tokenUtil, service);
    }



    @Test
    @DisplayName("Create authentication controller unauthorized test.")
    void createAuthenticationTokenTest_Unauthorized() {
        JwtRequestDto request = new JwtRequestDto("BLAH", "BLAH");
        ResponseEntity<?> actual = controller.createAuthenticationToken(request);
        assertEquals(HttpStatus.UNAUTHORIZED, actual.getStatusCode());
    }

    @Test
    @DisplayName("Create authentication controller authorized test.")
    void createAuthenticationTokenTest_Authorized() {
        Mockito.when(config.getJwtSecret()).thenReturn("testing");
        Mockito.when(config.getJwtValidity()).thenReturn((long)20);

        JwtRequestDto request = new JwtRequestDto("geekymon2@gmail.com", "password");
        ResponseEntity<?> actual = controller.createAuthenticationToken(request);
        assertEquals(HttpStatus.OK, actual.getStatusCode());
    }
}