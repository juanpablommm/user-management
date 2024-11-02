package com.challenge.ecommerce.tps.user_management.config.infrastructure;

import com.challenge.ecommerce.tps.user_management.authentication.application.AuthCommandHandler;
import com.challenge.ecommerce.tps.user_management.users.application.find.UserFindCommandHandler;
import com.challenge.ecommerce.tps.user_management.users.domain.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public UserFindCommandHandler userFindCommandHandler(final UserRepository userRepository) {
        return new UserFindCommandHandler(userRepository);
    }

    @Bean
    public AuthCommandHandler authCommandHandler(final UserRepository userRepository) {
        return new AuthCommandHandler();
    }
}
