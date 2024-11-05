package com.challenge.ecommerce.tps.user_management.users.application.delete;

import com.challenge.ecommerce.tps.user_management.users.domain.UserRepository;
import jakarta.transaction.Transactional;

public class DeleteCommandHandler {

	private final UserRepository userRepository;

	public DeleteCommandHandler(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Transactional
	public void handler(final String username) {
		this.userRepository.delete(username);
	}
}
