package com.challenge.ecommerce.tps.user_management.config.infrastructure;

import com.challenge.ecommerce.tps.encript.KeyRsaSupplier;
import com.challenge.ecommerce.tps.jwt.JwtManagement;
import com.challenge.ecommerce.tps.user_management.authentication.application.create.AuthCreateCommandHandler;
import com.challenge.ecommerce.tps.user_management.authentication.application.create.AuthWithPasswordAndEmail;
import com.challenge.ecommerce.tps.user_management.authentication.application.refresh.AuthRefreshCommandHandler;
import com.challenge.ecommerce.tps.user_management.authentication.domain.AuthRefreshTokenRepository;
import com.challenge.ecommerce.tps.user_management.users.application.find.UserFindCommandHandler;
import com.challenge.ecommerce.tps.user_management.users.domain.UserRepository;
import java.io.IOException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

@Configuration
public class ApplicationConfig {

	@Value("${settings-jks.path}")
	private String pathJks;

	@Value("${settings-jks.password}")
	private String passwordJks;

	@Value("${settings-jks.alias}")
	private String aliasJks;

	@Value("${settings-refresh-token.times.jwt}")
	private Long expiryTimeAtMinutes;

	@Bean
	public UserFindCommandHandler userFindCommandHandler(final UserRepository userRepository) {
		return new UserFindCommandHandler(userRepository);
	}

	@Bean
	public AuthCreateCommandHandler authCreateCommandHandler(final JwtManagement jwtManagement,
			final AuthWithPasswordAndEmail authWithPasswordAndEmail, final UserRepository userRepository,
			final AuthRefreshTokenRepository refreshTokenRepository) {

		return new AuthCreateCommandHandler(refreshTokenRepository, authWithPasswordAndEmail,
				jwtManagement::createToken, userRepository::findUserIdByEmail);
	}

	@Bean
	public AuthWithPasswordAndEmail authWithPasswordAndEmail(final AuthenticationManager authenticationManager) {
		return (email, password) -> {
			final Authentication authentication = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(email, password));
			return authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();
		};
	}

	@Bean
	public KeyRsaSupplier keyRsaSupplier()
			throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
		return new KeyRsaSupplier(this.passwordJks, this.aliasJks, this.pathJks);
	}

	@Primary
	@Bean
	public JwtManagement jwtManagement(final KeyRsaSupplier keyRsaSupplier) {
		return new JwtManagement(keyRsaSupplier, this.expiryTimeAtMinutes);
	}

	@Bean
	public AuthRefreshCommandHandler authRefreshCommandHandler(
			final AuthRefreshTokenRepository refreshTokenRepository) {
		return new AuthRefreshCommandHandler(refreshTokenRepository);
	}
}
