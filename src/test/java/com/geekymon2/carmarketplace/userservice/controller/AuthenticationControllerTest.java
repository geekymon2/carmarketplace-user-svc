package com.geekymon2.carmarketplace.userservice.controller;

import com.geekymon2.carmarketplace.core.autoconfiguration.security.jwt.JwtTokenUtil;
import com.geekymon2.carmarketplace.core.autoconfiguration.security.properties.JwtConfig;
import com.geekymon2.carmarketplace.userservice.models.JwtRequestDto;
import com.geekymon2.carmarketplace.userservice.serviceimpl.UserServiceImpl;
import io.jsonwebtoken.Jwts;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
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
class AuthenticationControllerTest {

    @Mock
    private static JwtConfig config;
    private final AuthenticationController controller;

    @Autowired
    public AuthenticationControllerTest(UserServiceImpl service) {
        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil(config);
        this.controller = new AuthenticationController(jwtTokenUtil, service);
    }

    @BeforeAll
    public static void setup() {
        config = new JwtConfig();
        config.setJwtSecret(Jwts.SIG.HS256.key().build().toString());
        config.setJwtValidity((long)20);
        config.setJwtDisabled(false);
    }


    @Test
    @DisplayName("Create authentication controller unauthorized test.")
    void createAuthenticationTokenTest_Unauthorized() {
        //BLAH, BLAH is invalid user
        JwtRequestDto request = new JwtRequestDto("BLAH", "BLAH");
        ResponseEntity<?> actual = controller.createAuthenticationToken(request);
        assertEquals(HttpStatus.UNAUTHORIZED, actual.getStatusCode());
    }

    @Test
    @DisplayName("Create authentication controller authorized test.")
    void createAuthenticationTokenTest_Authorized() {
        //geekymon2@gmail.com/password is a valid user for integration test
        JwtRequestDto request = new JwtRequestDto("geekymon2@gmail.com", "password");
        ResponseEntity<?> actual = controller.createAuthenticationToken(request);
        assertEquals(HttpStatus.OK, actual.getStatusCode());
    }
}