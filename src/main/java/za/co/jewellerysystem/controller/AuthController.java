package za.co.jewellerysystem.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.jewellerysystem.domain.User;
import za.co.jewellerysystem.domain.dto.LoginRequest;
import za.co.jewellerysystem.domain.dto.LoginResponse;
import za.co.jewellerysystem.domain.dto.UserRegistrationRequest;
import za.co.jewellerysystem.repository.UserRepository;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AuthController {

    private final UserRepository userRepository;

    @Autowired
    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegistrationRequest request) {
        // Check if email already exists
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            return ResponseEntity
                    .badRequest()
                    .body(new ErrorResponse("Email is already registered"));
        }
        // Save new user (no password hashing here)
        User user = new User(request.getFullName(), request.getEmail(), request.getPassword());
        userRepository.save(user);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        if (request.getEmail() == null || request.getEmail().isBlank() ||
                request.getPassword() == null || request.getPassword().isBlank()) {
            return ResponseEntity.badRequest().body(new ErrorResponse("Email and password are required"));
        }

        Optional<User> userOpt = userRepository.findByEmail(request.getEmail());
        if (userOpt.isEmpty()) {
            return ResponseEntity.status(401).body(new ErrorResponse("Invalid email or password"));
        }

        User user = userOpt.get();

        // Plain password check, only for testing!
        if (!user.getPasswordHash().equals(request.getPassword())) {
            return ResponseEntity.status(401).body(new ErrorResponse("Invalid email or password"));
        }

        LoginResponse.UserInfo userInfo = new LoginResponse.UserInfo(user.getId(), user.getFullName(), user.getEmail());
        LoginResponse response = new LoginResponse(userInfo);

        return ResponseEntity.ok(response);
    }

    static class ErrorResponse {
        private String message;

        public ErrorResponse(String message) {
            this.message = message;
        }

    }
}




