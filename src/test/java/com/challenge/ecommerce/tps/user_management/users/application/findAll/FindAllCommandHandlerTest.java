package com.challenge.ecommerce.tps.user_management.users.application.findAll;

import static org.junit.jupiter.api.Assertions.*;

import com.challenge.ecommerce.tps.user_management.users.application.UserMother;
import com.challenge.ecommerce.tps.user_management.users.application.find.UserNotFoundException;
import com.challenge.ecommerce.tps.user_management.users.domain.User;
import com.challenge.ecommerce.tps.user_management.users.domain.UserRepository;
import com.challenge.ecommerce.tps.user_management.users.infrastructure.UserInMemoryRepository;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class FindAllCommandHandlerTest {

	private final UserRepository userRepository = new UserInMemoryRepository();
	private final FindAllCommandHandler findAllCommandHandler = new FindAllCommandHandler(userRepository);

	@Test
	public void handlerShouldThrowUserNotFoundExceptionWhenNoUsersExist() {
		assertThrows(UserNotFoundException.class, () -> {
			findAllCommandHandler.handler(1, 100);
		});
	}

	@Test
	public void handlerShouldReturnUsersListWhenUsersExist() {
		final UserMother userMother = new UserMother();
		Stream.iterate(1, n -> n + 1).limit(100)
				.map(user -> userMother.withUsername(String.format("userByDefault%s", UUID.randomUUID())).build())
				.forEach(this.userRepository::save);

		final int page = 0;
		final int limit = 10;
		final List<User> users = findAllCommandHandler.handler(page, limit);
		assertFalse(users.isEmpty());
		assertEquals(10, users.size());
	}

}