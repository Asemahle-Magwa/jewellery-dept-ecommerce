package za.co.jewellerysystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import za.co.jewellerysystem.domain.User;
import za.co.jewellerysystem.domain.dto.UserDto;
import za.co.jewellerysystem.repository.UserRepository;

import java.util.Optional;
    @RestController
    @RequestMapping("/api/auth")
    public class AuthController {

        @Autowired
        private UserRepository userRepository;

        @Autowired
        private PasswordEncoder passwordEncoder;

        @PostMapping("/signup")
        public String signup(@RequestBody UserDto.SignupRequest request) {
            Optional<User> existingUser  = userRepository.findByUsername(request.getUsername());
            if (existingUser .isPresent()) {
                return "Username already taken";
            }
            User user = new User();
            user.setUsername(request.getUsername());
            user.setPassword(passwordEncoder.encode(request.getPassword()));
            userRepository.save(user);
            return "User  registered successfully";
        }

        @PostMapping("/login")
        public UserDto.LoginResponse login(@RequestBody UserDto.LoginRequest request) {
            Optional<User> userOpt = userRepository.findByUsername(request.getUsername());
            if (userOpt.isEmpty()) {
                return new UserDto.LoginResponse("User  not found", null);
            }
            User user = userOpt.get();
            if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
                return new UserDto.LoginResponse("Login successful", user.getUsername());
            } else {
                return new UserDto.LoginResponse("Invalid password", null);
            }
        }
    }


