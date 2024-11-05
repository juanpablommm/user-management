package com.challenge.ecommerce.tps.user_management.authentication.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class AuthResponseDto {

	private String accessToken;
	private String token;
}