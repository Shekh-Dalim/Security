package com.springsecuritypractice.practice.service;

import com.springsecuritypractice.practice.dto.UserRegisterRequestDto;
import com.springsecuritypractice.practice.dto.UserRegisterResponseDto;
import com.springsecuritypractice.practice.entity.User;
import com.springsecuritypractice.practice.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    public UserRegisterResponseDto register(UserRegisterRequestDto registerRequestDto) {

        User user = new User();
        user.setUserName(registerRequestDto.getUsername());
        String encodedPassword = passwordEncoder.encode(registerRequestDto.getPassword());
        user.setPassWord(encodedPassword);
        user.setEnabled(true);

        userRepository.save(user);


        UserRegisterResponseDto responseDto = new UserRegisterResponseDto();
        responseDto.setUsername(user.getUserName());
        responseDto.setMessage("User save successfully ");

        return responseDto;
    }


    public Boolean login(UserRegisterRequestDto userRegisterRequestDto){
        Optional<User> userOptional = userRepository.findByUserName(userRegisterRequestDto.getUsername());  // TODO put result in Optional.
        User user = userOptional.get();  // TODO (you open the box and take the User record out)

        String encodedPassword = user.getPassWord(); // TODO take password out of User.

        return passwordEncoder.matches(userRegisterRequestDto.getPassword(),encodedPassword);
    }
}
