package com.challenge.ecommerce.tps.user_management.users.infrastructure;

import com.challenge.ecommerce.tps.user_management.users.domain.User;

public interface UserMapper {

    public UserEntity toJpaEntity(User user);

    public User toDomain(UserEntity userEntity);
}
