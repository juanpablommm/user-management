package com.challenge.ecommerce.tps.user_management.authentication.infrastructure;

import com.challenge.ecommerce.tps.user_management.authentication.domain.AuthRefreshTokenRepository;
import com.challenge.ecommerce.tps.user_management.authentication.domain.RefreshToken;
import com.challenge.ecommerce.tps.user_management.users.infrastructure.UserEntity;
import java.time.OffsetDateTime;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
@AllArgsConstructor
public class AuthRefreshTokenJpaPostgresRepository implements AuthRefreshTokenRepository {

	private final AuthRefreshTokenJpaRepository refreshTokenJpaRepository;

	private final AuthRefreshTokenJpaMapper authRefreshTokenJpaMapper;

	@Override
	public Optional<RefreshToken> findByToken(final String token) {
		Optional<RefreshTokenEntity> userEntityOptional = this.refreshTokenJpaRepository.findByToken(token);
		return userEntityOptional.map(this.authRefreshTokenJpaMapper::toDomain);
	}

	@Override
	public void save(final RefreshToken refreshToken) {
		RefreshTokenEntity refreshTokenEntity = this.authRefreshTokenJpaMapper.toJpaEntity(refreshToken);
		final UserEntity userEntity = UserEntity.builder().userId(refreshToken.getUserId()).build();
		refreshTokenEntity.setUser(userEntity);
		this.refreshTokenJpaRepository.save(refreshTokenEntity);
	}

	@Override
	public void deleteAllExpiredTokens(OffsetDateTime currentDateTime) {
		this.refreshTokenJpaRepository.deleteAllExpiredTokens(currentDateTime);
	}
}
