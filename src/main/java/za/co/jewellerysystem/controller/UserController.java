package za.co.jewellerysystem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import za.co.jewellerysystem.domain.User;
import za.co.jewellerysystem.domain.dto.UserRegistrationRequest;
import za.co.jewellerysystem.repository.UserRepository;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser (@RequestBody UserRegistrationRequest request) {
        // Basic validation
        if (request.getFullName() == null || request.getFullName().isBlank() ||
                request.getEmail() == null || request.getEmail().isBlank() ||
                request.getPassword() == null || request.getPassword().isBlank()) {
            return ResponseEntity.badRequest().body(new ErrorResponse("All fields are required"));
        }

        // Check if email already exists
        Optional<User> existingUser  = userRepository.findByEmail(request.getEmail());
        if (existingUser .isPresent()) {
            return ResponseEntity.badRequest().body(new ErrorResponse("Email already registered"));
        }

        // Hash password
        String hashedPassword = passwordEncoder.encode(request.getPassword());

        // Save user
        User user = new User(request.getFullName(), request.getEmail(), hashedPassword);
        userRepository.save(user);

        return ResponseEntity.ok().body(new MessageResponse("User  registered successfully"));
    }

    // Response DTOs
    static class ErrorResponse {
        private String message;
        public ErrorResponse(String message) { this.message = message; }
        public String getMessage() { return message; }
    }

    static class MessageResponse {
        private String message;
        public MessageResponse(String message) { this.message = message; }
        public String getMessage() { return message; }
    }
}
