package com.challenge.ecommerce.tps.user_management.users.infrastructure;

import com.challenge.ecommerce.tps.user_management.users.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserModelMapper implements UserMapper {

	@Override
	public UserEntity toJpaEntity(User user) {
		return new UserEntity(user.getId(), user.getNames(), user.getSurnames(), user.getUsername(), user.getPassword(),
				user.getEmail(), user.getEnabled());
	}

	@Override
	public User toDomain(UserEntity userEntity) {
		return new User(userEntity.getUserId(), userEntity.getNames(), userEntity.getSurnames(),
				userEntity.getUsername(), userEntity.getPassword(), userEntity.getEmail(), userEntity.getEnabled());
	}
}
