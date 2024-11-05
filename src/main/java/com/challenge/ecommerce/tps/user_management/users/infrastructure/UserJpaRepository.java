package com.challenge.ecommerce.tps.user_management.users.infrastructure;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {

	Optional<UserEntity> findByEmailEqualsIgnoreCase(final String email);

	@Query(value = "SELECT user.userId FROM UserEntity user WHERE user.email = :email")
	Long findUserIdByEmail(final String email);

	Optional<UserEntity> findByUsernameIgnoreCase(final String username);

	void deleteByUsernameIgnoreCase(final String username);
}
