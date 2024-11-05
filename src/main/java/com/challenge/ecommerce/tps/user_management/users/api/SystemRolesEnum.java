package com.challenge.ecommerce.tps.user_management.users.api;

public enum SystemRolesEnum {

	ADMINISTRATOR("Administrador"), CUSTOMER("Cliente");

	private final String role;

	SystemRolesEnum(String role) {
		this.role = role;
	}

	public String getRole() {
		return role;
	}
}
