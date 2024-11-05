package com.challenge.ecommerce.tps.user_management.users.application.find;

import com.challenge.ecommerce.tps.user_management.users.domain.User;
import com.challenge.ecommerce.tps.user_management.users.domain.UserRepository;

public class FindUserCommandHandler {

	private final UserRepository userRepository;

	public FindUserCommandHandler(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User handler(final String username) {
		return this.userRepository.findByUsername(username)
				.orElseThrow(() -> new UserNotFoundException(String.format("User %s not found", username)));
	}
}
