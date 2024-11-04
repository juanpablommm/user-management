package com.challenge.ecommerce.tps.user_management.authentication.api;

import com.challenge.ecommerce.tps.user_management.authentication.domain.RefreshToken;
import com.challenge.ecommerce.tps.user_management.shared.infrastructure.ModelMapperFactory;
import org.springframework.stereotype.Component;

@Component
public class RefreshTokenApiModelMapper implements RefreshTokenApiMapper {

	@Override
	public AuthResponseDTO toAuthResponseDto(RefreshToken refreshToken) {
		return ModelMapperFactory.getModelMapper().map(refreshToken, AuthResponseDTO.class);
	}
}
