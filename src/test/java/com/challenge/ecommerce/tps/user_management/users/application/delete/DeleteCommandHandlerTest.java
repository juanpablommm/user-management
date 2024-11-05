package com.challenge.ecommerce.tps.user_management.users.application.delete;

import static org.junit.jupiter.api.Assertions.*;

import com.challenge.ecommerce.tps.user_management.users.application.UserMother;
import com.challenge.ecommerce.tps.user_management.users.domain.User;
import com.challenge.ecommerce.tps.user_management.users.domain.UserRepository;
import com.challenge.ecommerce.tps.user_management.users.infrastructure.UserInMemoryRepository;
import org.junit.jupiter.api.Test;

class DeleteCommandHandlerTest {

	private final UserRepository userRepository = new UserInMemoryRepository();
	private final DeleteCommandHandler deleteCommandHandler = new DeleteCommandHandler(userRepository);

	@Test
	void shouldCallDeleteOnRepositoryWhenHandlerIsCalled() {
		final String username = "usernameByDefault";
		final User user = new UserMother().withUsername(username).build();
		this.userRepository.save(user);
		this.deleteCommandHandler.handler(username);
		assertTrue(userRepository.findByUsername(username).isEmpty());
	}
}
