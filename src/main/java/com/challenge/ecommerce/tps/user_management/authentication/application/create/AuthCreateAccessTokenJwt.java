package com.challenge.ecommerce.tps.user_management.authentication.application.create;

import java.util.List;

@FunctionalInterface
public interface AuthCreateAccessTokenJwt {

	String createJWtToken(final String email, final List<String> roles);
}
