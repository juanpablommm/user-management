package com.challenge.ecommerce.tps.user_management.users.api;

import com.challenge.ecommerce.tps.user_management.users.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserApiModelMapper implements UserApiMapper {

	@Override
	public User toDomain(UserRequestDto userRequestDto) {
		return User.forCreate(userRequestDto.names(), userRequestDto.surnames(), userRequestDto.username(),
				userRequestDto.password(), userRequestDto.email(), userRequestDto.roles());
	}

	@Override
	public UserResponseDto toResponseDTO(User user) {
		return UserResponseDto.builder().email(user.getEmail()).enabled(user.getEnabled()).username(user.getUsername())
				.names(user.getNames()).roles(user.getRoles()).surnames(user.getSurnames()).build();
	}
}
