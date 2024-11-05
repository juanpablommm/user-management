package com.challenge.ecommerce.tps.user_management.users.application.create;

import com.challenge.ecommerce.tps.user_management.users.domain.User;
import com.challenge.ecommerce.tps.user_management.users.domain.UserRepository;
import jakarta.transaction.Transactional;

public class CreateUserCommandHandler {

	private final UserRepository userRepository;

	public CreateUserCommandHandler(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Transactional
	public void handler(User user) {
		this.userRepository.save(user);
	}
}
