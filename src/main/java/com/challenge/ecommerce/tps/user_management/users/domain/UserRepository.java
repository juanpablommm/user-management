package com.challenge.ecommerce.tps.user_management.users.domain;

import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;

public interface UserRepository {

	Optional<User> findByEmail(final String email);

	Optional<User> findByUsername(final String username);

	OptionalLong findUserIdByEmail(final String email);

	void save(final User user);

	void delete(final String username);

	List<User> findAll(final int page, final int limit);
}
