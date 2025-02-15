package com.securityjwt.studies.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AuthDTO(
        @NotBlank(message = "Username cannot empty")
        String username,

        @NotBlank(message = "Password cannot empty")
        @Size(min = 6)
        String password
        ) {}
