package com.challenge.ecommerce.tps.user_management.authentication.api;

import com.challenge.ecommerce.tps.user_management.authentication.application.AuthCommandHandler;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/auth")
@AllArgsConstructor
public class AuthenticationController {

	private final AuthenticationManager authenticationManager;

	@PostMapping(path = "/login")
	public ResponseEntity<String> authenticate(@Valid @RequestBody final AuthRequestDto authRequestDto) {
		AuthCommandHandler authCommandHandler = new AuthCommandHandler();
		final Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequestDto.email(), authRequestDto.password()));

		authCommandHandler.handler(authRequestDto.email());
		return ResponseEntity.ok("login..");
	}
}
