package za.co.jewellerysystem.controller;




import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import za.co.jewellerysystem.domain.User;
import za.co.jewellerysystem.repository.UserRepository;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class AuthController {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser (@RequestBody Map<String, String> body) {
        String fullName = body.get("fullName");
        String email = body.get("email");
        String password = body.get("password");

        if (userRepository.findByEmail(email).isPresent()) {
            return ResponseEntity.badRequest().body(Map.of("message", "Email is already in use"));
        }

        User user = new User();
        user.setFullName(fullName);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);

        return ResponseEntity.ok(Map.of("message", "User  registered successfully"));
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser (@RequestBody Map<String, String> body) {
        String email = body.get("email");
        String password = body.get("password");

        return userRepository.findByEmail(email)
                .map(user -> {
                    if (passwordEncoder.matches(password, user.getPassword())) {
                        // Return user info (no token)
                        return ResponseEntity.ok(Map.of(
                                "user", Map.of(
                                        "id", user.getId(),
                                        "fullName", user.getFullName(),
                                        "email", user.getEmail()
                                )
                        ));
                    } else {
                        return ResponseEntity.status(401).body(Map.of("message", "Invalid email or password"));
                    }
                })
                .orElseGet(() -> ResponseEntity.status(401).body(Map.of("message", "Invalid email or password")));
    }
}
