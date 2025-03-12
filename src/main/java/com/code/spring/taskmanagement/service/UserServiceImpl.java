package com.code.spring.taskmanagement.service;

import com.code.spring.taskmanagement.entity.User;
import com.code.spring.taskmanagement.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository theUserRepository){
        userRepository = theUserRepository;
    }

    // added implementation for return all Users
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
