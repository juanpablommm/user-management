package com.challenge.ecommerce.tps.user_management.authentication.application.refresh;

import static org.junit.jupiter.api.Assertions.*;

import com.challenge.ecommerce.tps.user_management.authentication.application.RefreshTokenMother;
import com.challenge.ecommerce.tps.user_management.authentication.domain.AuthRefreshTokenRepository;
import com.challenge.ecommerce.tps.user_management.authentication.domain.RefreshToken;
import com.challenge.ecommerce.tps.user_management.authentication.infrastructure.AuthRefreshTokenInMemoryRepository;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AuthRefreshCommandHandlerTest {

	private AuthRefreshCommandHandler authRefreshCommandHandler;

	private static final String VALID_REFRESH_TOKEN = String.valueOf(UUID.randomUUID());
	private static final String INVALID_REFRESH_TOKEN = String.valueOf(UUID.randomUUID());
	private static final RefreshTokenMother REFRESH_TOKEN_MOTHER = new RefreshTokenMother();
	private static final ZoneId ZONE_ID = ZoneId.of("America/Bogota");

	final AuthRefreshTokenRepository authRefreshTokenRepository = new AuthRefreshTokenInMemoryRepository();
	private RefreshToken validRefreshToken;
	private RefreshToken expiredRefreshToken;

	@BeforeEach
	void setUp() {
		this.authRefreshCommandHandler = new AuthRefreshCommandHandler(authRefreshTokenRepository);

		// We simulate refresh token with valid expiration time
		validRefreshToken = REFRESH_TOKEN_MOTHER.withRefreshTokenId(1L).withToken(VALID_REFRESH_TOKEN)
				.withExpiryTime(OffsetDateTime.now(ZONE_ID).plusMinutes(10)).build();

		// We simulate refresh token with invalid expiration time
		expiredRefreshToken = REFRESH_TOKEN_MOTHER.withRefreshTokenId(2L).withToken(INVALID_REFRESH_TOKEN)
				.withExpiryTime(OffsetDateTime.now(ZONE_ID).minusMinutes(10)).build();

		this.authRefreshTokenRepository.save(expiredRefreshToken);
		this.authRefreshTokenRepository.save(validRefreshToken);
	}

	@Test
	void shouldReturnRefreshTokenWhenTokenIsValid() {
		final RefreshToken result = authRefreshCommandHandler.handler(VALID_REFRESH_TOKEN);
		assertNotNull(result);
		assertEquals(validRefreshToken, result);

		// It is verified that the refresh token has not been deleted
		assertNotNull(this.authRefreshTokenRepository.findByToken(VALID_REFRESH_TOKEN));
	}

	@Test()
	void shouldThrowExceptionWhenTokenNotFound() {
		assertThrows(CanNotGeneratedAuthRefreshException.class, () -> {
			authRefreshCommandHandler.handler(String.valueOf(UUID.randomUUID()));
		});
	}

	@Test
	void shouldThrowExceptionAndDeleteExpiredTokensWhenTokenIsExpired() {
		assertThrows(CanNotGeneratedAuthRefreshException.class, () -> {
			authRefreshCommandHandler.handler(INVALID_REFRESH_TOKEN);
		});
		// It is validated that the token has been deleted
		assertTrue(this.authRefreshTokenRepository.findByToken(INVALID_REFRESH_TOKEN).isEmpty());
	}
}
