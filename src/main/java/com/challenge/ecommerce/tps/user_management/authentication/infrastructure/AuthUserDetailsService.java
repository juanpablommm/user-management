package com.challenge.ecommerce.tps.user_management.authentication.infrastructure;

import com.challenge.ecommerce.tps.user_management.users.domain.User;
import com.challenge.ecommerce.tps.user_management.users.domain.UserRepository;
import com.challenge.ecommerce.tps.user_management.users.infrastructure.UserModelMapper;
import java.util.Objects;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

	private UserRepository userRepository;

	private UserModelMapper userMapper;

	@Override
	public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email)
				.orElseThrow(() -> new AuthInfrastructureException("User with email not found in UserDetailsService"));

		if (Objects.equals(Boolean.FALSE, user.getEnabled()))
			throw new AuthInfrastructureException("User was disabled");
		return this.userMapper.toJpaEntity(user);
	}
}
