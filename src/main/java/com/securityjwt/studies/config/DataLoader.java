package com.securityjwt.studies.config;

import java.util.List;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.securityjwt.studies.model.entity.Role;
import com.securityjwt.studies.model.entity.RoleName;
import com.securityjwt.studies.model.entity.User;
import com.securityjwt.studies.repository.RoleRepository;
import com.securityjwt.studies.repository.UserRepository;

@Component
public class DataLoader implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataLoader(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {

        Role userRole = new Role();
        userRole.setName(RoleName.ROLE_USER);

        Role managerRole = new Role();
        managerRole.setName(RoleName.ROLE_MANAGER);

        roleRepository.saveAll(List.of(userRole, managerRole));

        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("123456"));
        admin.setRoles(Set.of(userRole, managerRole));

        userRepository.save(admin);

    }

}
