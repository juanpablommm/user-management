package com.challenge.ecommerce.tps.user_management.users.infrastructure;

import com.challenge.ecommerce.tps.user_management.users.domain.User;
import com.challenge.ecommerce.tps.user_management.users.domain.UserRepository;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
@AllArgsConstructor
public class UserJpaPostgresRepository implements UserRepository {

	private final UserJpaRepository userJpaRepository;

	private final UserModelMapper userMapper;

	@Override
	public Optional<User> findByEmail(final String email) {
		Optional<UserEntity> userEntityOptional = this.userJpaRepository.findByEmailEqualsIgnoreCase(email);
		return userEntityOptional.map(this.userMapper::toDomain);
	}
}
