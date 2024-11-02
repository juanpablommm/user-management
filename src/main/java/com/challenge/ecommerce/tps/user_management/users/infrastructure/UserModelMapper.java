package com.challenge.ecommerce.tps.user_management.users.infrastructure;

import com.challenge.ecommerce.tps.user_management.shared.infrastructure.ModelMapperFactory;
import com.challenge.ecommerce.tps.user_management.users.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserModelMapper {

	public UserEntity toJpaEntity(User user) {
		return ModelMapperFactory.getModelMapper().map(user, UserEntity.class);
	}

	public User toDomain(UserEntity userEntity) {
		return ModelMapperFactory.getModelMapper().map(userEntity, User.class);
	}
}
