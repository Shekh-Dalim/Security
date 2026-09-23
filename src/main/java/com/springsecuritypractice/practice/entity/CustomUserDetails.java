package com.springsecuritypractice.practice.entity;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class CustomUserDetails implements UserDetails {

    private User user;
    public CustomUserDetails(User user) {
        this.user = user;
    }

    //TODO this method return role User → Roles → GrantedAuthority → Spring Security.
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getRoles()
                .stream()
                .map(role ->
                        new SimpleGrantedAuthority(
                                role.getName()
                        )
                )
                .toList();
    }

    @Override
    public @Nullable String getPassword() {
        return user.getPassWord();  // TODO: This method returns the user's password
    }

    @Override
    public String getUsername() {
        return user.getUserName();  // TODO: This method returns the user's username
    }

    @Override
    public boolean isEnabled() {
        return user.isEnabled();  // TODO: This method returns whether the user is enabled
    }
}
