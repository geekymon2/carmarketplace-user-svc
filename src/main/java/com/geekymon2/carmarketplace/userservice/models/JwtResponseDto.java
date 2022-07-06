package com.geekymon2.carmarketplace.userservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponseDto implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private String jwtToken;
}