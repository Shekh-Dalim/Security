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

    private RoleService roleService;
    public RoleController(RoleService roleService){
        this.roleService = roleService;
    }

    @PostMapping
    public ResponseEntity<String> addRole(@RequestBody Role role){
        roleService.addRole(role);  // TODO Send/pass the role object from the Controller to the Service.
        return ResponseEntity.ok("Done");
    }

}
