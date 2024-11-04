package com.challenge.ecommerce.tps.user_management.authentication.application.create;

@FunctionalInterface
public interface AuthCreateAccessTokenJwt {

	String createJWtToken(final String username, final String roles);
}
