package com.springsecuritypractice.practice.service;

import com.springsecuritypractice.practice.dto.UserRegisterRequestDto;
import com.springsecuritypractice.practice.dto.UserRegisterResponseDto;
import com.springsecuritypractice.practice.entity.Role;
import com.springsecuritypractice.practice.entity.User;
import com.springsecuritypractice.practice.repository.RoleRepository;
import com.springsecuritypractice.practice.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AuthService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private RoleRepository roleRepository;

    public AuthService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;

    }

    public UserRegisterResponseDto register(UserRegisterRequestDto registerRequestDto) {

        User user = new User();
        user.setUserName(registerRequestDto.getUsername());
        String encodedPassword = passwordEncoder.encode(registerRequestDto.getPassword());
        user.setPassWord(encodedPassword);
        user.setEnabled(true);

//        Role role = roleRepository.findByName("ROLE_USER").orElseThrow(() -> new RuntimeException("ROLE_USER not found"));
        Role role = roleRepository.findByName("ROLE_USER").get();
        user.getRoles().add(role);  // TODO user.getRoles() "Give me the user's existing roles box." and add(role) the role
        userRepository.save(user);

        UserRegisterResponseDto responseDto = new UserRegisterResponseDto();
        responseDto.setUsername(user.getUserName());
        responseDto.setMessage("User save successfully ");

        return responseDto;
    }


}
