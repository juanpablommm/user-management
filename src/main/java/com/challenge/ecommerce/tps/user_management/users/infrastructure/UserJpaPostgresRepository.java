package com.challenge.ecommerce.tps.user_management.users.infrastructure;

import com.challenge.ecommerce.tps.user_management.role.infrastructure.RoleEntity;
import com.challenge.ecommerce.tps.user_management.role.infrastructure.RoleJpaRepository;
import com.challenge.ecommerce.tps.user_management.users.domain.User;
import com.challenge.ecommerce.tps.user_management.users.domain.UserRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;
import java.util.Set;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Primary
@Component
@AllArgsConstructor
public class UserJpaPostgresRepository implements UserRepository {

	private final UserJpaRepository userJpaRepository;

	private final RoleJpaRepository roleJpaRepository;

	private final UserMapper userMapper;

	@Override
	public Optional<User> findByEmail(final String email) {
		Optional<UserEntity> userEntityOptional = this.userJpaRepository.findByEmailEqualsIgnoreCase(email);
		return userEntityOptional.map(this.userMapper::toDomain);
	}

	@Override
	public Optional<User> findByUsername(final String username) {
		Optional<UserEntity> userEntityOptional = this.userJpaRepository.findByUsernameIgnoreCase(username);
		return userEntityOptional.map(this.userMapper::toDomain);
	}

	@Override
	public OptionalLong findUserIdByEmail(final String email) {
		return OptionalLong.of(this.userJpaRepository.findUserIdByEmail(email));
	}

	@Transactional
	@Override
	public void save(final User user) {
		final Set<RoleEntity> roles = this.roleJpaRepository.findByRoleNameIn(user.getRoles());
		final UserEntity userEntity = this.userMapper.toJpaEntity(user);
		userEntity.setRoles(roles);
		this.userJpaRepository.save(userEntity);
	}

	@Transactional
	@Override
	public void delete(String username) {
		this.userJpaRepository.deleteByUsernameIgnoreCase(username);
	}

	@Override
	public List<User> findAll(final int page, final int limit) {
		final Page<UserEntity> userEntityPage = this.userJpaRepository.findAll(PageRequest.of(page, limit));
		return userEntityPage.getContent().stream().map(this.userMapper::toDomain).toList();
	}
}
