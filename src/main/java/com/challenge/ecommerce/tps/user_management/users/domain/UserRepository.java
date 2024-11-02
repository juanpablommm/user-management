package com.challenge.ecommerce.tps.user_management.users.domain;

import java.util.Optional;

public interface UserRepository {

	Optional<User> findByEmail(final String email);

	// OptionalDouble create(User user);

	// OptionalDouble update(User user);
}
