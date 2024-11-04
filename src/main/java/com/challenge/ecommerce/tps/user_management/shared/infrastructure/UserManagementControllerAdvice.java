package com.challenge.ecommerce.tps.user_management.shared.infrastructure;

import com.challenge.ecommerce.tps.exceptions.JwtManagementException;
import com.challenge.ecommerce.tps.exceptions.SecurityLibraryException;
import com.challenge.ecommerce.tps.user_management.authentication.application.refresh.CanNotGeneratedAuthRefreshException;
import com.challenge.ecommerce.tps.user_management.authentication.infrastructure.AuthInfrastructureException;
import java.security.KeyManagementException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@Slf4j
public class UserManagementControllerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(JwtManagementException.class)
	public final ResponseEntity<String> handlerJwtManagementException(JwtManagementException exception) {
		log.error("Internal error - authentication: {}", exception.getMessage());
		return ResponseEntity.internalServerError().body("Internal error - authentication");
	}

	@ExceptionHandler(KeyManagementException.class)
	public final ResponseEntity<String> handlerKeyManagementException(KeyManagementException exception) {
		log.error("Internal error - authentication keys: {}", exception.getMessage());
		return ResponseEntity.internalServerError().body("Internal error - authentication keys");
	}

	@ExceptionHandler(SecurityLibraryException.class)
	public final ResponseEntity<String> handlerSecurityLibraryException(SecurityLibraryException exception) {
		log.error("Internal error - security library: {}", exception.getMessage());
		return ResponseEntity.internalServerError().body("Internal error - security library");
	}

	@ExceptionHandler(AuthInfrastructureException.class)
	public final ResponseEntity<String> handlerUserNotFoundException(AuthInfrastructureException exception) {
		log.error("Authentication Error - Forbidden: {}", exception.getMessage());
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Authentication Error - Forbidden");
	}

	@ExceptionHandler(CanNotGeneratedAuthRefreshException.class)
	public final ResponseEntity<String> handlerCanNotGeneratedAuthRefreshException(
			CanNotGeneratedAuthRefreshException exception) {
		log.error("Token Expired or not Exit - Log in Again: {}", exception.getMessage());
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Token Expired or not Exit - Log in Again");
	}

}
