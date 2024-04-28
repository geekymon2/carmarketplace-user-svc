package com.geekymon2.carmarketplace.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"com.geekymon2.carmarketplace.userservice",
		"com.geekymon2.carmarketplace.core.autoconfiguration.security.jwt",
		"com.geekymon2.carmarketplace.core.autoconfiguration.security.properties"})
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

}
