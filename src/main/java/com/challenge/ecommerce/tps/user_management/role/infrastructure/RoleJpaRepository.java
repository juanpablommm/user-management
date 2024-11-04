package com.challenge.ecommerce.tps.user_management.role.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleJpaRepository extends JpaRepository<RoleEntity, Long> {
}
