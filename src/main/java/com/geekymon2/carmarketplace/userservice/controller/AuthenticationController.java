package com.geekymon2.carmarketplace.userservice.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.geekymon2.carmarketplace.userservice.serviceimpl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.geekymon2.carmarketplace.core.models.ErrorResponseDto;
import com.geekymon2.carmarketplace.core.autoconfiguration.security.jwt.JwtTokenUtil;
import com.geekymon2.carmarketplace.userservice.models.AuthenticationStatus;
import com.geekymon2.carmarketplace.userservice.models.JwtRequestDto;
import com.geekymon2.carmarketplace.userservice.models.JwtResponseDto;

@Slf4j
@RestController
public class AuthenticationController {

	@Autowired
	private final JwtTokenUtil jwtTokenUtil;
	private final UserServiceImpl service;

	public AuthenticationController(JwtTokenUtil jwtTokenUtil, UserServiceImpl service) {
		this.service = service;
		this.jwtTokenUtil = jwtTokenUtil;
	}

    @PostMapping(value = "/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequestDto authenticationRequest) {
		AuthenticationStatus status = authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());

		if (!status.getIsAuthenticated()) {
			List<String> details = new ArrayList<>();
			details.add(status.getMessage());
			ErrorResponseDto error = new ErrorResponseDto(new Date(), HttpStatus.UNAUTHORIZED.value(), "UNAUTHORIZED", details, "uri");
			return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
		}

		final String token = jwtTokenUtil.generateToken(authenticationRequest.getEmail());
		return ResponseEntity.ok(new JwtResponseDto(token));
	}

	private AuthenticationStatus authenticate(String email, String password) {
		AuthenticationStatus status;

		if (this.service.validateUserPassword(email, password)) {
			status = new AuthenticationStatus(true, "Authentication Successful");
		}
		else {
			status = new AuthenticationStatus(false, "Invalid Username/Password");
		}

		return status;
	}
}
