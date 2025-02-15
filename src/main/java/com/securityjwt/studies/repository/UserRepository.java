package com.securityjwt.studies.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.securityjwt.studies.model.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
