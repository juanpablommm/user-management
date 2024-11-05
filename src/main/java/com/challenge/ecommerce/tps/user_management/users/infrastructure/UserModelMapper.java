package com.challenge.ecommerce.tps.user_management.users.infrastructure;

import com.challenge.ecommerce.tps.user_management.role.infrastructure.RoleEntity;
import com.challenge.ecommerce.tps.user_management.users.domain.User;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserModelMapper implements UserMapper {

	private final PasswordEncoder passwordEncoder;

	@Override
	public UserEntity toJpaEntity(User user) {
		return new UserEntity(user.getId(), user.getNames(), user.getSurnames(), user.getUsername(),
				this.passwordEncoder(user.getPassword()), user.getEmail(), user.getEnabled(),
				this.getRolesForJpa(user.getRoles()));
	}

	@Override
	public User toDomain(UserEntity userEntity) {
		return new User(userEntity.getUserId(), userEntity.getNames(), userEntity.getSurnames(),
				userEntity.getUsername(), userEntity.getPassword(), userEntity.getEmail(), userEntity.getEnabled(),
				this.getRolesForDomain(userEntity.getRoles()));
	}

	private Set<RoleEntity> getRolesForJpa(Set<String> roles) {
		RoleEntity.RoleEntityBuilder roleBuilder = RoleEntity.builder();
		return roles.stream().map(rol -> roleBuilder.roleName(rol).build()).collect(Collectors.toSet());
	}

	private Set<String> getRolesForDomain(Set<RoleEntity> roles) {
		return roles.stream().map(RoleEntity::getRoleName).collect(Collectors.toSet());
	}

	private String passwordEncoder(final String password) {
		if (Objects.isNull(password) || password.matches("^\\$2[ayb]\\$\\d{2}\\$[./A-Za-z0-9]{53}$"))
			return password;
		return this.passwordEncoder.encode(password);
	}
}
