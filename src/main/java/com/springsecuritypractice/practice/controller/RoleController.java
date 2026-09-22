package com.springsecuritypractice.practice.controller;

import com.springsecuritypractice.practice.entity.Role;
import com.springsecuritypractice.practice.service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/roles")
public class RoleController {

    private RoleService roleSservice;
    public RoleController(RoleService roleService){
        this.roleSservice = roleService;
    }

    @PostMapping
    public ResponseEntity<String> addRole(@RequestBody Role role){
        roleSservice.addRole(role);
        return ResponseEntity.ok("Done");
    }

}
