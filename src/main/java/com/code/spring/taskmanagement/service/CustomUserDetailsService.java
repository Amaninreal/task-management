package com.code.spring.taskmanagement.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    // Later you can inject UserRepository here to fetch user from DB

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Hardcoded user for now, replace with DB call later
        if ("testuser".equals(username)) {
            return new User("testuser", "{noop}testpass", new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found!");
        }
    }
}
