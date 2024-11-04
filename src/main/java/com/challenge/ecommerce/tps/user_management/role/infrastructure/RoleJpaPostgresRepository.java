package com.challenge.ecommerce.tps.user_management.role.infrastructure;

import com.challenge.ecommerce.tps.user_management.role.domain.RolRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
@AllArgsConstructor
public class RoleJpaPostgresRepository implements RolRepository {

	private final RoleJpaRepository repository;
}
