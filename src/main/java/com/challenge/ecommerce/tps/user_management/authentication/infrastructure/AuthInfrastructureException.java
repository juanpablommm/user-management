package com.challenge.ecommerce.tps.user_management.authentication.infrastructure;

public class AuthInfrastructureException extends RuntimeException {

	public AuthInfrastructureException(String message) {
		super(String.format("Error in user authentication:  %s", message));
	}

	public AuthInfrastructureException(String message, Throwable cause) {
		super(String.format("Error in user authentication:  %s", message), cause);
	}
}
