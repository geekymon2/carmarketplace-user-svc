package com.geekymon2.carmarketplace.userservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatusDto {
    String environment;
    String version;
    String hostname;  
    String description;  
}
