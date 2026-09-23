package com.springsecuritypractice.practice.service;

import com.springsecuritypractice.practice.entity.Role;
import com.springsecuritypractice.practice.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private RoleRepository roleRepository;
    public RoleService(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    public void addRole(Role role){
        roleRepository.save(role);  // TODO persist object to DB
    }
}
