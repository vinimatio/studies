package com.securityjwt.studies.service;

import java.util.List;

import com.securityjwt.studies.model.dto.UserCreateDTO;
import com.securityjwt.studies.model.dto.UserResponseDTO;

public interface UserService {
    
    UserResponseDTO createUser(UserCreateDTO userDTO);

    List<UserResponseDTO> getAllUsers();
}
