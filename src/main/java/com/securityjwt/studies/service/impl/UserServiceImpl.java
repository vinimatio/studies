package com.securityjwt.studies.service.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.securityjwt.studies.model.dto.UserCreateDTO;
import com.securityjwt.studies.model.dto.UserResponseDTO;
import com.securityjwt.studies.model.entity.Role;
import com.securityjwt.studies.model.entity.User;
import com.securityjwt.studies.repository.RoleRepository;
import com.securityjwt.studies.repository.UserRepository;
import com.securityjwt.studies.service.UserService;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository,
            PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public UserResponseDTO createUser(UserCreateDTO userDTO) {

        User newUser = new User();

        newUser.setUsername(userDTO.username());
        newUser.setPassword(passwordEncoder.encode(userDTO.password()));

        Set<Role> roles = userDTO.roles().stream()
                .map(roleName -> roleRepository.findByName(roleName)
                        .orElseThrow(() -> new RuntimeException("Role não encontrada: " + roleName)))
                .collect(Collectors.toSet());

        newUser.setRoles(roles);
        return UserResponseDTO.fromEntity(userRepository.save(newUser));
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll().stream().map(UserResponseDTO::fromEntity).toList();
    }

}
