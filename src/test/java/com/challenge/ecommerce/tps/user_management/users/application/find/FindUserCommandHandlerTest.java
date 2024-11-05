package com.challenge.ecommerce.tps.user_management.users.application.find;

import static org.junit.jupiter.api.Assertions.*;

import com.challenge.ecommerce.tps.user_management.users.application.UserMother;
import com.challenge.ecommerce.tps.user_management.users.domain.User;
import com.challenge.ecommerce.tps.user_management.users.domain.UserRepository;
import com.challenge.ecommerce.tps.user_management.users.infrastructure.UserInMemoryRepository;
import org.junit.jupiter.api.Test;

class FindUserCommandHandlerTest {

	private final UserRepository userRepository = new UserInMemoryRepository();
	private final FindUserCommandHandler findUserCommandHandler = new FindUserCommandHandler(userRepository);

	@Test
	void shouldReturnUserWhenUsernameExists() {
		final String username = "usernameBuyDefault";
		final User user = new UserMother().withUsername(username).build();
		this.userRepository.save(user);

		final User result = this.findUserCommandHandler.handler(username);
		assertNotNull(result);
		assertEquals(user, result);
	}

	@Test
	void shouldThrowExceptionWhenUsernameDoesNotExist() {
		final String username = "nonExistentUser";
		assertThrows(UserNotFoundException.class, () -> {
			this.findUserCommandHandler.handler(username);
		});
	}
}