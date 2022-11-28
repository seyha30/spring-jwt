package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.domain.Role;

/**
 * @author sseyha
 * @date Nov 28, 2022 9:38:25 PM
 */
@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {

	Role findByName(String name);
}
 