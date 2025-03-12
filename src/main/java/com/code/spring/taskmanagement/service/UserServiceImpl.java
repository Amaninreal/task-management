package com.code.spring.taskmanagement.service;

import com.code.spring.taskmanagement.entity.User;
import com.code.spring.taskmanagement.exception.ResourceNotFoundException;
import com.code.spring.taskmanagement.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository theUserRepository){
        userRepository = theUserRepository;
    }

    // added implementation for return all Users
    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        if (users.isEmpty()) {
            throw new ResourceNotFoundException("No users found in the system.");
        }
        return users;
    }

    @Override
    public Optional<User> getUserById(Long userId) {
        return Optional.ofNullable(userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId)));
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long userId, User userDetails) {
        User user = getUserById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + userId));

        user.setUsername(userDetails.getUsername());
        user.setEmail(userDetails.getEmail());
        user.setRole(userDetails.getRole());
        user.setActive(userDetails.getActive());

        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long userId) {
        User user = getUserById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + userId));
        userRepository.delete(user);
    }
}
