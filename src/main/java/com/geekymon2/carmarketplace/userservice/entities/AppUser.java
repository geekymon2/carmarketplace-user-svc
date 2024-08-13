package com.geekymon2.carmarketplace.userservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "appuser")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "firstname is mandatory")
    private String firstname;
    @NotBlank(message = "lastname is mandatory")
    private String lastname;
    @NotBlank(message = "email is mandatory")
    @Column(unique = true)
    private String email;
    @NotBlank(message = "password is mandatory")
    private String password;
    private Boolean isActive;
    private Boolean isVerified;
    @NotNull(message = "created date is mandatory")
    private Timestamp createdDate;
    private Timestamp lastLoginDate;
}
