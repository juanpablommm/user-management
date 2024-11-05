package com.challenge.ecommerce.tps.user_management.users.api;

import com.challenge.ecommerce.tps.user_management.users.application.create.CreateUserCommandHandler;
import com.challenge.ecommerce.tps.user_management.users.application.delete.DeleteCommandHandler;
import com.challenge.ecommerce.tps.user_management.users.application.find.FindUserCommandHandler;
import com.challenge.ecommerce.tps.user_management.users.application.findAll.FindAllCommandHandler;
import com.challenge.ecommerce.tps.user_management.users.domain.User;
import jakarta.validation.Valid;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/user")
@AllArgsConstructor
public class UserController {

	private final CreateUserCommandHandler createUserCommandHandler;
	private final FindUserCommandHandler findUserCommandHandler;
	private final FindAllCommandHandler findAllCommandHandler;
	private final DeleteCommandHandler deleteCommandHandler;
	private final UserApiMapper userApiMapper;

	@PostMapping(path = "/create")
	public ResponseEntity<?> create(@RequestBody @Valid UserRequestDto createUserRequestDto) {
		User user = this.userApiMapper.toDomain(createUserRequestDto);
		this.createUserCommandHandler.handler(user);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@GetMapping(path = "/find")
	public ResponseEntity<UserResponseDto> getByUsername(@RequestParam String username) {
		final User user = this.findUserCommandHandler.handler(username);
		return ResponseEntity.ok(this.userApiMapper.toResponseDTO(user));
	}

	@DeleteMapping(path = "/delete")
	public ResponseEntity<?> deleteByUsername(@RequestParam String username) {
		this.deleteCommandHandler.handler(username);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	// TODO al implemantar la criteria api y specifcation mirar si se cambia a una
	// library
	@GetMapping(path = "/find/all")
	public ResponseEntity<List<UserResponseDto>> findAll(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int limit) {
		final List<User> users = this.findAllCommandHandler.handler(page, limit);
		return ResponseEntity.ok(users.stream().map(this.userApiMapper::toResponseDTO).toList());
	}
}
