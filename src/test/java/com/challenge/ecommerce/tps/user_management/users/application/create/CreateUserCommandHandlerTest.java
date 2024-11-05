package com.challenge.ecommerce.tps.user_management.users.application.create;

import static org.junit.jupiter.api.Assertions.*;

import com.challenge.ecommerce.tps.user_management.users.application.UserMother;
import com.challenge.ecommerce.tps.user_management.users.domain.User;
import com.challenge.ecommerce.tps.user_management.users.domain.UserRepository;
import com.challenge.ecommerce.tps.user_management.users.infrastructure.UserInMemoryRepository;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class CreateUserCommandHandlerTest {

	private final UserRepository userRepository = new UserInMemoryRepository();

	private final CreateUserCommandHandler createUserCommandHandler = new CreateUserCommandHandler(userRepository);

	@Test
	void shouldSaveUserWhenHandlerIsCalled() {
		final String username = "usernameByDefault";
		final User user = new UserMother().withUsername(username).build();
		this.createUserCommandHandler.handler(user);
		Optional<User> userFound = this.userRepository.findByUsername(username);
		assertTrue(userFound.isPresent());
		assertEquals(username, userFound.get().getUsername());
	}
}
