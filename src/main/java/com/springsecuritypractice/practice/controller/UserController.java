package com.springsecuritypractice.practice.controller;

import com.springsecuritypractice.practice.dto.UserRegisterRequestDto;
import com.springsecuritypractice.practice.dto.UserRegisterResponseDto;
import com.springsecuritypractice.practice.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private AuthService authService;

    public UserController(AuthService authService) {
        this.authService = authService;
    }


    @GetMapping("/hello")
    public String getStudent() {
        return "Hello";
    }

    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponseDto> register(@RequestBody UserRegisterRequestDto registerRequestDto) {

        UserRegisterResponseDto userRegisterResponseDto = authService.register(registerRequestDto);
        return ResponseEntity.ok(userRegisterResponseDto);
    }

//    @GetMapping("/token")
//    public CsrfToken getToken(CsrfToken csrfToken) {
//        return csrfToken;
//    }

}
