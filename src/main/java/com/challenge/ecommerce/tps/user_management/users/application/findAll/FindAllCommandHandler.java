package com.challenge.ecommerce.tps.user_management.users.application.findAll;

import com.challenge.ecommerce.tps.user_management.users.application.find.UserNotFoundException;
import com.challenge.ecommerce.tps.user_management.users.domain.User;
import com.challenge.ecommerce.tps.user_management.users.domain.UserRepository;
import java.util.List;

public class FindAllCommandHandler {

	private final UserRepository userRepository;

	public FindAllCommandHandler(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> handler(final int page, final int limit) {
		final List<User> users = userRepository.findAll(page, limit);
		if (users.isEmpty())
			throw new UserNotFoundException("The user list is empty, no data was found");
		return users;
	}
}
