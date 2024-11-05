package com.challenge.ecommerce.tps.user_management.users.api;

import java.util.Set;
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
public class UserResponseDto {

	private String names;
	private String surnames;
	private String username;
	private String email;
	private Boolean enabled;
	private Set<String> roles;
}
