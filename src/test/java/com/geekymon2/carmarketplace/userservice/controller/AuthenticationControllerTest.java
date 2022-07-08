package com.geekymon2.carmarketplace.userservice.controller;

import com.geekymon2.carmarketplace.core.security.autoconfiguration.jwt.JwtTokenUtil;
import com.geekymon2.carmarketplace.userservice.models.JwtRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
@TestPropertySource(locations = "classpath:application-test.yml")
class AuthenticationControllerTest {
    private final AuthenticationController controller;

    @Autowired
    public AuthenticationControllerTest(JwtTokenUtil tokenUtil) {
        this.controller = new AuthenticationController(tokenUtil);
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
        JwtRequestDto request = new JwtRequestDto("foo", "foo");
        ResponseEntity<?> actual = controller.createAuthenticationToken(request);
        assertEquals(HttpStatus.OK, actual.getStatusCode());
    }
}