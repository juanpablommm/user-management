package com.challenge.ecommerce.tps.user_management.authentication.application.create;

@FunctionalInterface
public interface AuthWithPasswordAndEmail {

	String authentication(final String password, final String email);
}
