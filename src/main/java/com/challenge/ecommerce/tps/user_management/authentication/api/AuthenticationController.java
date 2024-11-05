package com.challenge.ecommerce.tps.user_management.authentication.api;

import com.challenge.ecommerce.tps.user_management.authentication.api.create.AuthCreateRequestDto;
import com.challenge.ecommerce.tps.user_management.authentication.api.refresh.AuthRefreshTokenRequestDTO;
import com.challenge.ecommerce.tps.user_management.authentication.application.create.AuthCreateCommandHandler;
import com.challenge.ecommerce.tps.user_management.authentication.application.refresh.AuthRefreshCommandHandler;
import com.challenge.ecommerce.tps.user_management.authentication.domain.RefreshToken;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/auth")
@AllArgsConstructor
public class AuthenticationController {

	private final AuthCreateCommandHandler authCreateCommandHandler;
	private final AuthRefreshCommandHandler authRefreshCommandHandler;
	private final RefreshTokenApiMapper refreshTokenApiMapper;

	@PostMapping(path = "/login")
	public ResponseEntity<AuthResponseDto> createAuthenticate(
			@Valid @RequestBody final AuthCreateRequestDto authRequestDto) {
		final RefreshToken refreshToken = this.authCreateCommandHandler.handler(authRequestDto.email(),
				authRequestDto.password());
		return ResponseEntity.ok(this.refreshTokenApiMapper.toAuthResponseDto(refreshToken));
	}

	@PostMapping(path = "/refresh")
	public ResponseEntity<AuthResponseDto> refreshAuthenticate(
			@RequestBody AuthRefreshTokenRequestDTO authRefreshTokenRequestDTO) {
		final RefreshToken refreshToken = this.authRefreshCommandHandler.handler(authRefreshTokenRequestDTO.token());
		return ResponseEntity.ok(this.refreshTokenApiMapper.toAuthResponseDto(refreshToken));
	}

}
