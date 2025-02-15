package com.securityjwt.studies.model.dto;

import java.util.Set;
import java.util.stream.Collectors;

import com.securityjwt.studies.model.entity.User;

public record UserResponseDTO(
        Long id,
        String username,
        Set<String> roles) {

    public static UserResponseDTO fromEntity(User user) {
        return new UserResponseDTO(user.getId(), user.getUsername(),
                user
                        .getRoles()
                        .stream()
                        .map(role -> role
                                .getName()
                                .name())
                        .collect(Collectors.toSet()));
    }
}
