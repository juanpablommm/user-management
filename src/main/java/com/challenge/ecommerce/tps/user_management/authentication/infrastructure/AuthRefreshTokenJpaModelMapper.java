package com.challenge.ecommerce.tps.user_management.authentication.infrastructure;

import com.challenge.ecommerce.tps.jwt.JwtManagement;
import com.challenge.ecommerce.tps.user_management.authentication.domain.RefreshToken;
import com.challenge.ecommerce.tps.user_management.role.infrastructure.RoleEntity;
import com.challenge.ecommerce.tps.user_management.shared.infrastructure.ModelMapperFactory;
import com.challenge.ecommerce.tps.user_management.users.infrastructure.UserEntity;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AuthRefreshTokenJpaModelMapper implements AuthRefreshTokenJpaMapper {

	private final JwtManagement jwtManagement;

	public RefreshTokenEntity toJpaEntity(final RefreshToken refreshToken) {
		RefreshTokenEntity refreshTokenEntity = ModelMapperFactory.getModelMapper().map(refreshToken,
				RefreshTokenEntity.class);
		refreshTokenEntity.setUser(UserEntity.builder().userId(refreshToken.getUserId()).build());
		return refreshTokenEntity;
	}

	public RefreshToken toDomain(final RefreshTokenEntity refreshTokenEntity) {
		final UserEntity userEntity = refreshTokenEntity.getUser();
		final List<String> roles = userEntity.getRoles().stream().map(RoleEntity::getRoleName).toList();
		return new RefreshToken(userEntity.getUserId(), refreshTokenEntity.getToken(),
				jwtManagement.createToken(userEntity.getEmail(), roles), refreshTokenEntity.getExpiryTime(),
				refreshTokenEntity.getUser().getUserId());
	}
}
