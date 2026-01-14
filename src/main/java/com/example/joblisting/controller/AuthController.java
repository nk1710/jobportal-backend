package com.example.joblisting.controller;

import com.example.joblisting.dto.LoginRequest;
import com.example.joblisting.model.User;
import com.example.joblisting.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    // ✅ SIGN UP
    @PostMapping("/signup")
    public User signup(@RequestBody User user) {

        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            throw new RuntimeException("Email already registered");
        }

        return userRepository.save(user); // 🔥 ID auto-generate
    }

    // ✅ SIGN IN
    @PostMapping("/login")
    public User login(@RequestBody LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return user; // 🔥 Frontend ko id + role milega
    }
}
