package com.challenge.ecommerce.tps.user_management.users.domain;

import java.util.Optional;
import java.util.OptionalLong;

public interface UserRepository {

	Optional<User> findByEmail(final String email);

	OptionalLong findUserIdByEmail(final String email);
}
