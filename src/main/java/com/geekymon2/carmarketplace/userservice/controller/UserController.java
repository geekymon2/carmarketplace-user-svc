package com.geekymon2.carmarketplace.userservice.controller;

import com.geekymon2.carmarketplace.userservice.serviceimpl.UserServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.mappers.ModelMapper;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserServiceImpl service;
    private final ModelMapper mapper;

    public UserController(UserServiceImpl service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }
}
