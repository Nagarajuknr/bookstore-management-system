package com.bookstore.service;

import org.springframework.stereotype.Service;
import com.bookstore.model.User;
import com.bookstore.repository.UserRepository;
import java.util.Optional;

@Service
public class AuthService {
    
    private final UserRepository userRepository;
    
    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    // Register new user
    public User register(User user) {
        // Check if email already exists
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists!");
        }
        
        // In production, you should hash the password using BCrypt
        // For now, storing plain text (NOT recommended for production)
        return userRepository.save(user);
    }
    
    // Login user
    public User login(String email, String password, String role) {
        Optional<User> userOpt = userRepository.findByEmail(email);
        
        if (!userOpt.isPresent()) {
            throw new RuntimeException("Invalid email or password!");
        }
        
        User user = userOpt.get();
        
        // Check password
        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid email or password!");
        }
        
        // Check role
        if (!user.getRole().equals(role)) {
            throw new RuntimeException("Access denied for this role!");
        }
        
        return user;
    }
}