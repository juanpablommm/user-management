package com.challenge.ecommerce.tps.user_management.users.infrastructure;

import com.challenge.ecommerce.tps.user_management.users.domain.User;
import com.challenge.ecommerce.tps.user_management.users.domain.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalLong;
import org.springframework.stereotype.Component;

@Component
public class UserInMemoryRepository implements UserRepository {

	private final List<User> users = new ArrayList<>();

	@Override
	public Optional<User> findByEmail(final String email) {
		return this.users.stream().filter(user -> Objects.equals(user.getEmail(), email)).findFirst();
	}

	@Override
	public Optional<User> findByUsername(final String username) {
		return this.users.stream().filter(user -> Objects.equals(user.getUsername(), username)).findFirst();
	}

	@Override
	public OptionalLong findUserIdByEmail(final String email) {
		return this.users.stream().filter(user -> Objects.equals(user.getEmail(), email)).mapToLong(User::getId)
				.findFirst();
	}

	@Override
	public void save(final User user) {
		this.users.add(user);
	}

	@Override
	public void delete(final String username) {
		this.findByUsername(username).ifPresent(this.users::remove);
	}

	@Override
	public List<User> findAll(final int page, final int limit) {
		return users.stream().skip((long) page * limit).limit(limit).toList();
	}
}
