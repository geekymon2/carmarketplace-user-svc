package com.geekymon2.carmarketplace.userservice.controller;

import com.geekymon2.carmarketplace.core.security.autoconfiguration.jwt.JwtTokenUtil;
import com.geekymon2.carmarketplace.core.security.autoconfiguration.properties.JwtConfig;
import com.geekymon2.carmarketplace.userservice.models.JwtRequestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
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
    private JwtConfig config;
    private AuthenticationController controller;

    @BeforeEach
    public void setup(){
        JwtTokenUtil tokenUtil = new JwtTokenUtil(config);
        controller = new AuthenticationController(tokenUtil);
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

        JwtRequestDto request = new JwtRequestDto("foo", "foo");
        ResponseEntity<?> actual = controller.createAuthenticationToken(request);
        assertEquals(HttpStatus.OK, actual.getStatusCode());
    }
}