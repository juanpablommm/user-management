package com.challenge.ecommerce.tps.user_management.users.api;

import com.challenge.ecommerce.tps.user_management.users.application.find.UserFindCommandHandler;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/user")
@AllArgsConstructor
public class UserController {

	private final UserFindCommandHandler userFindCommandHandler;

	@GetMapping(path = "/find/{email}")
	public ResponseEntity<String> findEmail(@PathVariable String email) {
		this.userFindCommandHandler.findByEmailCommandHandler();
		return ResponseEntity.ok("login.....");
	}
}
