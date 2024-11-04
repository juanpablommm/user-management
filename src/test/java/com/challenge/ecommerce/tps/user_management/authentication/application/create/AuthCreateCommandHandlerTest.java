package com.challenge.ecommerce.tps.user_management.authentication.application.create;

import static org.junit.jupiter.api.Assertions.*;

import com.challenge.ecommerce.tps.user_management.authentication.domain.AuthRefreshTokenRepository;
import com.challenge.ecommerce.tps.user_management.authentication.domain.RefreshToken;
import com.challenge.ecommerce.tps.user_management.authentication.infrastructure.AuthRefreshTokenInMemoryRepository;
import java.util.List;
import java.util.OptionalLong;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AuthCreateCommandHandlerTest {

	private AuthCreateCommandHandler authCreateCommandHandler;
	private static final String ACCESS_TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJSb2xlIjoiQWRtaW5pc3RyYWRvciIsInN1YiI6Imp1YW5wYWJsb21vbnRveWE2MThAZ21haWwuY29tIiwiZXhwIjoxNzMwNzUyMjQ3fQ.XKIVjZv4uxgvSavo2ap0Wzk2gGhttjHFoJMyUdirTwBN3IhYLcUJQ4z31lS7fadY5_6MRRNd1x-FjnJBXBrPEsivCgOto4usxERZPjbY7ALuiQqpzJyrdSGGYQyebUHZq6l-KFOPNVKPEsyScTW2hjfUxYNEeiNLSnTvSY4a5JAVlJp1t4AEddiZfZFR5xHzOixN0Kw2K_0Eomqc6E1CbN4E6bSsMYRUT6tEDPKReBv9XqHpRUy8M8JR-vLy94uLGirQh6G4w_BuMGFcvAT5wX-T_8eIDDIY16FKh1DU5bkHlpSKTtfRNRfMQCeqzFTAHW37I4Geg_jJLlVsFgiIPg";

	@BeforeEach
	public void setup() {
		final AuthRefreshTokenRepository auhRefreshTokenRepository = new AuthRefreshTokenInMemoryRepository();

		/*
		 * Spring Security internal authentication is simulated by returning the
		 * respective roles
		 */
		final AuthWithPasswordAndEmail authWithPasswordAndEmail = (password, email) -> List.of("Administrador",
				"Cliente");

		/*
		 * We simulate the creation of the JWT access token, by passing it email and
		 * roles
		 */
		final AuthCreateAccessTokenJwt authCreateAccessTokenJwt = (email, roles) -> ACCESS_TOKEN;

		/*
		 * We simulate obtaining the ID of the user for whom the authentication is being
		 * created.
		 */
		final AuthUserIdByEmailFetcher userIdByEmailFetcher = (email) -> OptionalLong.of(1L);

		this.authCreateCommandHandler = new AuthCreateCommandHandler(auhRefreshTokenRepository,
				authWithPasswordAndEmail, authCreateAccessTokenJwt, userIdByEmailFetcher);

	}

	@Test
	public void shouldAuthenticateUserAndGenerateRefreshToken() {
		final String email = "juampisGonzales@defualt.com";
		final String password = "password12345";
		final RefreshToken refreshToken = this.authCreateCommandHandler.handler(email, password);
		assertNotNull(refreshToken);
		assertNotNull(refreshToken.getToken());
		assertEquals(ACCESS_TOKEN, refreshToken.getAccessToken());
		assertEquals(1L, refreshToken.getUserId());
	}
}
