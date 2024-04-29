package com.geekymon2.carmarketplace.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * additional packages need to be scanned to get the JWT authentication working
 * JWT authentication classes are present in the core library
 */
@SpringBootApplication(scanBasePackages = {"com.geekymon2.carmarketplace.userservice",
		"com.geekymon2.carmarketplace.core.autoconfiguration"})
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

}
