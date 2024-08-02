package com.geekymon2.carmarketplace.userservice.controller;

import com.geekymon2.carmarketplace.core.common.ApiStatus;
import com.geekymon2.carmarketplace.core.models.StatusDto;
import com.geekymon2.carmarketplace.userservice.entities.AppUser;
import com.geekymon2.carmarketplace.userservice.models.UserDto;
import com.geekymon2.carmarketplace.userservice.serviceimpl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserServiceImpl service;
    private final ModelMapper mapper;

    public UserController(UserServiceImpl service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping(value = "/status")
    public StatusDto getStatus() {
        return new ApiStatus().getStatus();
    }

    @GetMapping(value = "/users")
    public List<UserDto> getUsers() {
        return service.getUsers().stream().map(this::appUserToDto).collect(Collectors.toList());
    }

    @GetMapping(value = "/validate")
    private Boolean validateUserPassword(String email, String password) {
        return service.validateUserPassword(email, password);
    }

    @PostMapping(value = "/register")
    public Long registerUser(UserDto userDto) {
        AppUser user = dtoToAppUser(userDto);
        user.setCreatedDate(new Timestamp(System.currentTimeMillis()));

        return service.registerUser(user);
    }

    private UserDto appUserToDto(AppUser user) {
        return mapper.map(user, UserDto.class);
    }

    private AppUser dtoToAppUser(UserDto dto) {
        return mapper.map(dto, AppUser.class);
    }



}
