package com.geekymon2.carmarketplace.userservice.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Boolean isActive;
    private Boolean isVerified;
    private Date createdDate;
    private Date lastLoginDate;
}
