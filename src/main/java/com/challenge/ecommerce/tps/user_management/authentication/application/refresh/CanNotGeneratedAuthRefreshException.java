package com.challenge.ecommerce.tps.user_management.authentication.application.refresh;

public class CanNotGeneratedAuthRefreshException extends RuntimeException {

	public CanNotGeneratedAuthRefreshException(String message) {
		super(String.format("Error generating refresh token: %s", message));
	}

	public CanNotGeneratedAuthRefreshException(String message, Throwable cause) {
		super(String.format("Error generating refresh token: %s", message));
	}
}
