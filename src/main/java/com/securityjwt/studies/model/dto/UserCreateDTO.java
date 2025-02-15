package com.securityjwt.studies.model.dto;

import java.util.Set;

import com.securityjwt.studies.model.entity.RoleName;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserCreateDTO(
        @NotBlank String username,
        @Size(min = 6, message = "mínimo de 6 caracteres") String password,
        Set<RoleName> roles) {

}
