package com.challenge.ecommerce.tps.user_management.authentication.api;

import com.challenge.ecommerce.tps.user_management.authentication.domain.RefreshToken;

public interface RefreshTokenApiMapper {

	AuthResponseDto toAuthResponseDto(final RefreshToken refreshToken);
}
