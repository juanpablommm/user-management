package com.challenge.ecommerce.tps.user_management.authentication.application.create;

import java.util.OptionalLong;

@FunctionalInterface
public interface AuthUserIdByEmailFetcher {

	OptionalLong fetch(final String email);
}
