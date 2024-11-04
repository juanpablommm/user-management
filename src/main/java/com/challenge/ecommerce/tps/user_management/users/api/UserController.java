package com.challenge.ecommerce.tps.user_management.users.api;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/user")
@AllArgsConstructor
public class UserController {

	// private final UserFindCommandHandler userFindCommandHandler;

	@GetMapping(path = "/find")
	public ResponseEntity<String> findEmail() {
		// this.userFindCommandHandler.findByEmailCommandHandler();
		return ResponseEntity.ok("login.....");
	}
}
