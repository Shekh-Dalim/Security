package com.springsecuritypractice.practice.service;

import com.springsecuritypractice.practice.entity.CustomUserDetails;
import com.springsecuritypractice.practice.entity.User;
import com.springsecuritypractice.practice.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException(
                        "User Not Found"
                ));
        return new CustomUserDetails(user);  // TODO Create a CustomUserDetails object and put this User object inside it.
    }
}
