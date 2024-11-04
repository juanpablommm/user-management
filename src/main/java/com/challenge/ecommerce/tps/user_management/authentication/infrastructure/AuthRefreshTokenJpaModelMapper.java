package com.challenge.ecommerce.tps.user_management.authentication.infrastructure;

import com.challenge.ecommerce.tps.user_management.authentication.domain.RefreshToken;
import com.challenge.ecommerce.tps.user_management.shared.infrastructure.ModelMapperFactory;
import com.challenge.ecommerce.tps.user_management.users.infrastructure.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class AuthRefreshTokenJpaModelMapper implements AuthRefreshTokenJpaMapper {

	public RefreshTokenEntity toJpaEntity(final RefreshToken refreshToken) {
		RefreshTokenEntity refreshTokenEntity = ModelMapperFactory.getModelMapper().map(refreshToken,
				RefreshTokenEntity.class);
		refreshTokenEntity.setUser(UserEntity.builder().userId(refreshToken.getUserId()).build());
		return refreshTokenEntity;
	}

	public RefreshToken toDomain(RefreshTokenEntity refreshTokenEntity) {
		return ModelMapperFactory.getModelMapper().map(refreshTokenEntity, RefreshToken.class);
	}
}
