package com.challenge.ecommerce.tps.user_management.shared.infrastructure;

import com.challenge.ecommerce.tps.exceptions.JwtManagementException;
import com.challenge.ecommerce.tps.exceptions.SecurityLibraryException;
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
	public final ResponseEntity<String> handleJwtManagementException(JwtManagementException exception) {
		log.error("Internal error - authentication: {}", exception.getMessage());
		return ResponseEntity.internalServerError().body("Internal error - authentication");
	}

	@ExceptionHandler(KeyManagementException.class)
	public final ResponseEntity<String> handleKeyManagementException(KeyManagementException exception) {
		log.error("Internal error - authentication keys: {}", exception.getMessage());
		return ResponseEntity.internalServerError().body("Internal error - authentication keys");
	}

	@ExceptionHandler(SecurityLibraryException.class)
	public final ResponseEntity<String> handleSecurityLibraryException(SecurityLibraryException exception) {
		log.error("Internal error - security library: {}", exception.getMessage());
		return ResponseEntity.internalServerError().body("Internal error - security library");
	}

	@ExceptionHandler(AuthInfrastructureException.class)
	public final ResponseEntity<String> handleUserNotFoundException(AuthInfrastructureException exception) {
		log.error("Authentication Error - Forbidden: {}", exception.getMessage());
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Authentication Error - Forbidden");
	}

}
