package com.geekymon2.carmarketplace.userservice.controller;

import com.geekymon2.carmarketplace.userservice.entities.User;
import com.geekymon2.carmarketplace.userservice.models.StatusDto;
import com.geekymon2.carmarketplace.userservice.models.UserDto;
import com.geekymon2.carmarketplace.userservice.serviceimpl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.io.IOException;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
        String hostname = "";
        String environment = "";
        String version = "0.0.0";
        final String UNKNOWN_LABEL = "unknown";

        try {
            hostname = java.net.InetAddress.getLocalHost().getHostName();
            environment = System.getenv("ENVIRONMENT");
            version = Files.readString(Paths.get("/version.properties")).split("=")[1];
        }
        catch (UnknownHostException uhx) {
            hostname = UNKNOWN_LABEL;
            log.error(String.format("Error getting hostname: %s", uhx));
        }
        catch (IOException iox) {
            version = UNKNOWN_LABEL;
            log.error(String.format("Error getting version: %s", iox));
        }

        return new StatusDto(environment, version, hostname, "This is the status endpoint");
    }

    @GetMapping(value = "/users")
    public List<UserDto> getUsers() {
        return service.getUsers().stream().map(this::userToDto).collect(Collectors.toList());
    }

    private UserDto userToDto(User car) {
        return mapper.map(car, UserDto.class);
    }

}
