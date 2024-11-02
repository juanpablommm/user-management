package com.challenge.ecommerce.tps.user_management.users.application.find;

import com.challenge.ecommerce.tps.user_management.users.domain.User;
import com.challenge.ecommerce.tps.user_management.users.domain.UserRepository;

public class UserFindCommandHandler {

    private final UserRepository userRepository;

    public UserFindCommandHandler(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByEmailCommandHandler () {
        this.userRepository.findByEmail("name");
        return null;
    }
}
