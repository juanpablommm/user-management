package com.challenge.ecommerce.tps.user_management.users.api;

import com.challenge.ecommerce.tps.user_management.users.domain.User;

public interface UserApiMapper {

	User toDomain(final UserRequestDto createUserRequestDto);

	UserResponseDto toResponseDTO(final User user);
}
