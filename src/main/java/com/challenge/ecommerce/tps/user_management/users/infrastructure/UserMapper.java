package com.challenge.ecommerce.tps.user_management.users.infrastructure;

import com.challenge.ecommerce.tps.user_management.users.domain.User;

public interface UserMapper {

	UserEntity toJpaEntity(User user);

	User toDomain(UserEntity userEntity);
}
