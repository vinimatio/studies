package com.securityjwt.studies.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.securityjwt.studies.config.JwtConfig;
import com.securityjwt.studies.model.dto.AuthDTO;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtConfig jwtConfig;

    public AuthService(AuthenticationManager authenticationManager, JwtConfig jwtConfig) {
        this.authenticationManager = authenticationManager;
        this.jwtConfig = jwtConfig;
    }

    public String authenticate(AuthDTO authDTO) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(authDTO.username(), authDTO.password()));

        return jwtConfig.generateToken(authentication);
    }
}
