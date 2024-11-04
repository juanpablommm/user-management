package com.challenge.ecommerce.tps.user_management.authentication.api;

import com.challenge.ecommerce.tps.user_management.authentication.domain.RefreshToken;

public interface RefreshTokenApiMapper {

	AuthResponseDTO toAuthResponseDto(final RefreshToken refreshToken);
}
