package com.challenge.ecommerce.tps.user_management.authentication.domain;

import java.time.OffsetDateTime;
import java.util.Optional;

public interface AuthRefreshTokenRepository {

	Optional<RefreshToken> findByToken(final String token);

	void save(final RefreshToken refreshToken);

	void deleteAllExpiredTokens(OffsetDateTime currentDateTime);

}
