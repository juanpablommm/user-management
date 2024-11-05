package com.challenge.ecommerce.tps.user_management.users.application.find;

public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(String message) {
		super(String.format("Error the user cannot be found: %s", message));
	}

	public UserNotFoundException(String message, Throwable cause) {
		super(String.format("Error the user cannot be found: %s", message));
	}
}
