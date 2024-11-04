package com.challenge.ecommerce.tps.user_management.users.application;

import com.challenge.ecommerce.tps.user_management.users.domain.User;
import java.util.Set;

public class UserMother {
	private Long id = 1L;
	private String names = "name default";
	private String surnames = "surnames default";
	private String username = "usernameDefault";
	private String password = "defaultPassword";
	private String email = "default@default.com";
	private Boolean enabled = Boolean.TRUE;
	private Set<String> roles = Set.of("Administrador");

	public UserMother withId(Long id) {
		this.id = id;
		return this;
	}

	public UserMother withNames(String names) {
		this.names = names;
		return this;
	}

	public UserMother withSurnames(String surnames) {
		this.surnames = surnames;
		return this;
	}

	public UserMother withUsername(String username) {
		this.username = username;
		return this;
	}

	public UserMother withPassword(String password) {
		this.password = password;
		return this;
	}

	public UserMother withEmail(String email) {
		this.email = email;
		return this;
	}

	public UserMother withEnabled(Boolean enabled) {
		this.enabled = enabled;
		return this;
	}

	public UserMother withRoles(Set<String> roles) {
		this.roles = roles;
		return this;
	}

	public User build() {
		return new User(id, names, surnames, username, password, email, enabled, roles);
	}
}
