package com.travel.ticketing.controllers;

import com.travel.ticketing.models.User;
import com.travel.ticketing.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/profile")
    public ResponseEntity<?> getUserProfile(@AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails == null) {
            return ResponseEntity.status(401).body("Unauthorized");
        }

        // Fetch user from DB
        Optional<User> userOptional = userRepository.findByUsername(userDetails.getUsername());

        if (userOptional.isPresent()) {
            User user = userOptional.get();

            // ✅ Modified response format (Removed 'enabled')
            Map<String, Object> response = new HashMap<>();
            response.put("id", user.getId());
            response.put("username", user.getUsername());
            response.put("email", user.getEmail());
            response.put("role", user.getRole().toString());

            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(404).body("User not found");
        }
    }

}
