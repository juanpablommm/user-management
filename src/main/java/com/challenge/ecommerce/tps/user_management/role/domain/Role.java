package com.challenge.ecommerce.tps.user_management.role.domain;

import java.util.Objects;

public class Role {

	private final Long id;

	final String roleName;

	final String description;

	public Role(Long id, String roleName, String description) {
		this.id = id;
		this.roleName = roleName;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public String getRoleName() {
		return roleName;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Role role = (Role) o;
		return Objects.equals(getId(), role.getId()) && Objects.equals(getRoleName(), role.getRoleName())
				&& Objects.equals(getDescription(), role.getDescription());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getRoleName(), getDescription());
	}

	@Override
	public String toString() {
		return "Role{" + "id=" + id + ", roleName='" + roleName + '\'' + ", description='" + description + '\'' + '}';
	}
}
