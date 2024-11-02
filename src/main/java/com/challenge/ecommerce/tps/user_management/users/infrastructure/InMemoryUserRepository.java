package com.challenge.ecommerce.tps.user_management.users.infrastructure;

import com.challenge.ecommerce.tps.user_management.users.domain.User;
import com.challenge.ecommerce.tps.user_management.users.domain.UserRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class InMemoryUserRepository implements UserRepository {


    @Override
    public Optional<User> findByEmail(final String email) {
        return Optional.empty();
    }
}
