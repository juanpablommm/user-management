package com.challenge.ecommerce.tps.user_management.users.infrastructure;

import com.challenge.ecommerce.tps.user_management.users.domain.User;
import com.challenge.ecommerce.tps.user_management.users.domain.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

	private UserRepository userRepository;

	private UserModelMapper userMapper;

	@Override
	public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Erro autehntication..."));
		/*
		 * if (!user.isEnabled()) throw new
		 * UserManagementException(ApplicationMessagesEnum.FAIL_AUTHENTICATION.
		 * getMessages(), HttpStatus.UNAUTHORIZED);
		 */
		return this.userMapper.toJpaEntity(user);
	}
}
