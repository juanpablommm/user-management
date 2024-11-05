package com.challenge.ecommerce.tps.user_management.role.infrastructure;

import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleJpaRepository extends JpaRepository<RoleEntity, Long> {

	Set<RoleEntity> findByRoleNameIn(Set<String> roleNames);
}
