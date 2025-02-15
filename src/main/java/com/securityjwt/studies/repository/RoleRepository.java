package com.securityjwt.studies.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.securityjwt.studies.model.entity.Role;
import com.securityjwt.studies.model.entity.RoleName;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName name);
}
