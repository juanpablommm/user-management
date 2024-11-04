package com.challenge.ecommerce.tps.user_management.authentication.application.create;

import com.challenge.ecommerce.tps.user_management.authentication.domain.AuthRefreshTokenRepository;
import com.challenge.ecommerce.tps.user_management.authentication.domain.RefreshToken;
import java.time.OffsetDateTime;
import java.util.UUID;

public class AuthCreateCommandHandler {

	private final AuthRefreshTokenRepository refreshTokenRepository;
	private final AuthWithPasswordAndEmail authWithPasswordAndEmail;
	private final AuthCreateAccessTokenJwt authCreateAccessTokenJwt;
	private final AuthUserIdByEmailFetcher userIdByEmailFetcher;

	public AuthCreateCommandHandler(AuthRefreshTokenRepository authRefreshTokenRepository,
			AuthWithPasswordAndEmail authWithPasswordAndEmail, AuthCreateAccessTokenJwt authCreateAccessTokenJwt,
			AuthUserIdByEmailFetcher authUserIdByEmailFetcher) {
		this.refreshTokenRepository = authRefreshTokenRepository;
		this.authWithPasswordAndEmail = authWithPasswordAndEmail;
		this.authCreateAccessTokenJwt = authCreateAccessTokenJwt;
		this.userIdByEmailFetcher = authUserIdByEmailFetcher;
	}

	public RefreshToken handler(final String email, final String password) {
		String roles = this.authWithPasswordAndEmail.authentication(email, password);
		final Long userId = this.userIdByEmailFetcher.fetch(email).orElseThrow();
		final String accessToken = this.authCreateAccessTokenJwt.createJWtToken(email, roles);
		final RefreshToken refreshToken = new RefreshToken(String.valueOf(UUID.randomUUID()), accessToken,
				OffsetDateTime.now().plusMinutes(10), userId);
		this.refreshTokenRepository.save(refreshToken);
		return refreshToken;
	}
}
