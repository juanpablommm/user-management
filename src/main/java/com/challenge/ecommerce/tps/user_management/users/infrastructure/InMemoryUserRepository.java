package com.challenge.ecommerce.tps.user_management.users.infrastructure;

import com.challenge.ecommerce.tps.user_management.users.domain.User;
import com.challenge.ecommerce.tps.user_management.users.domain.UserRepository;
import java.util.Optional;
import java.util.OptionalLong;
import org.springframework.stereotype.Component;

@Component
public class InMemoryUserRepository implements UserRepository {

	@Override
	public Optional<User> findByEmail(final String email) {
		return Optional.empty();
	}

	@Override
	public OptionalLong findUserIdByEmail(final String email) {
		return OptionalLong.empty();
	}

}
