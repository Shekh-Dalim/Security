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
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;

    }

    public UserRegisterResponseDto register(UserRegisterRequestDto registerRequestDto) {

        User user = new User();  // TODO Create an User obj
        user.setUserName(registerRequestDto.getUsername());  // TODO set username
        String encodedPassword = passwordEncoder.encode(registerRequestDto.getPassword());  // TODO encode the password
        user.setPassWord(encodedPassword); // TODO set the password
        user.setEnabled(true);

        Role role = roleRepository.findByName("ROLE_USER").get();  // TODO Set the role
        user.getRoles().add(role);  // TODO Add the given role to the user's roles collection.        user.getRoles() "Give me the user's existing roles box." and add(role) the role
        userRepository.save(user); // TODO save the user to the DB

        UserRegisterResponseDto responseDto = new UserRegisterResponseDto();
        responseDto.setUsername(user.getUserName());
        responseDto.setMessage("User save successfully ");

        return responseDto;
    }


}
