package com.springsecuritypractice.practice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping("/hello")
    public String getStudent() {
        return "Hello";
    }

//    @PostMapping
//    public ResponseEntity<String> createStudent() {
//        return ResponseEntity.ok("Student created Successfully");
//    }
//
//    @DeleteMapping
//    public ResponseEntity<String> deleteStudent() {
//        return ResponseEntity.ok("Student delete Successfully");
//    }
//
//    @PutMapping
//    public ResponseEntity<String> updateStudent() {
//        return ResponseEntity.ok("Student update Successfully");
//    }
//
//    // This code only used to run the post delete and put.
//    @GetMapping("/csrf")
//    public CsrfToken getToken(CsrfToken csrfToken) {
//        return csrfToken;
//    }

}
