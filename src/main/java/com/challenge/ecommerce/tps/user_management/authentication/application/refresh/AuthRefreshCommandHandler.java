package com.challenge.ecommerce.tps.user_management.authentication.application.refresh;

import com.challenge.ecommerce.tps.user_management.authentication.domain.AuthRefreshTokenRepository;
import com.challenge.ecommerce.tps.user_management.authentication.domain.RefreshToken;
import jakarta.transaction.Transactional;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.Optional;

public class AuthRefreshCommandHandler {

	private final AuthRefreshTokenRepository refreshTokenRepository;

	public AuthRefreshCommandHandler(AuthRefreshTokenRepository refreshTokenRepository) {
		this.refreshTokenRepository = refreshTokenRepository;
	}

	@Transactional(dontRollbackOn = CanNotGeneratedAuthRefreshException.class)
	public RefreshToken handler(final String refreshToken) {
		Optional<RefreshToken> refreshTokenOptional = this.refreshTokenRepository.findByToken(refreshToken);
		if (refreshTokenOptional.isEmpty())
			throw new CanNotGeneratedAuthRefreshException("The refresh token was not found");

		final RefreshToken refreshTokenFound = refreshTokenOptional.get();
		this.validateExpiryTimeRefreshToken(refreshTokenFound);
		return refreshTokenFound;
	}

	private void validateExpiryTimeRefreshToken(RefreshToken refreshTokenFound) {
		final OffsetDateTime timeNow = OffsetDateTime.now(ZoneId.of("America/Bogota"));
		if (refreshTokenFound.getExpiryTime().isBefore(timeNow)) {
			this.refreshTokenRepository.deleteAllExpiredTokens(timeNow);
			throw new CanNotGeneratedAuthRefreshException("The refresh token has expired");
		}
	}
}
