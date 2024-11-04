package com.challenge.ecommerce.tps.user_management.authentication.infrastructure;

import java.time.OffsetDateTime;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRefreshTokenJpaRepository extends JpaRepository<RefreshTokenEntity, Long> {

	Optional<RefreshTokenEntity> findByToken(final String token);

	@Modifying
	@Query("DELETE FROM RefreshTokenEntity refreshToken WHERE refreshToken.expiryTime < :currentDateTime")
	void deleteAllExpiredTokens(final OffsetDateTime currentDateTime);
}
