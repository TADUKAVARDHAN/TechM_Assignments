package com.travel.ticketing.controllers;

import com.travel.ticketing.models.User;
import com.travel.ticketing.repositories.UserRepository;
import com.travel.ticketing.security.JwtUtil;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200") // ✅ Allow frontend access
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserDetailsService userDetailsService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;  // ✅ Password encoder for hashing

    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil,
                          UserDetailsService userDetailsService, UserRepository userRepository,
                          PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // ✅ REGISTER A NEW USER
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User newUser) {
        System.out.println("🔹 Registration attempt for: " + newUser.getUsername());

        // 🔍 Check if username or email already exists
        if (userRepository.findByUsername(newUser.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Username already taken"));
        }

        if (userRepository.findByEmail(newUser.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Email already in use"));
        }

        // 🔑 Hash the password before saving
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));

        // 🔹 Save user
        userRepository.save(newUser);
        return ResponseEntity.ok(Map.of("message", "User registered successfully!"));
    }

 // ✅ LOGIN USER
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginUser) {
        System.out.println("🔹 Login attempt for: " + loginUser.getUsername());

        // 🔍 Check if user exists
        User user = userRepository.findByUsername(loginUser.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        System.out.println("✅ Found user: " + user.getUsername());
        System.out.println("🔹 Stored hashed password: " + user.getPassword());
        System.out.println("🔹 Entered password: " + loginUser.getPassword());

        // 🔑 Validate password
        if (!passwordEncoder.matches(loginUser.getPassword(), user.getPassword())) {
            System.out.println("❌ Password mismatch!");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(Map.of("error", "Invalid username or password"));
        }

        System.out.println("✅ Password verified! Proceeding with authentication...");

        try {
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword())
            );

            // ✅ Generate JWT Token
            String token = jwtUtil.generateToken(user.getUsername());

            // ✅ Prepare response with user details
            Map<String, Object> response = new HashMap<>();
            response.put("token", token);
            response.put("message", "Login successful");
            response.put("user", Map.of(
                "id", user.getId(),
                "username", user.getUsername(),
                "email", user.getEmail(),
                "role", user.getRole().name() // ✅ Ensure role is correctly formatted
            ));

            System.out.println("🎉 Login successful for user: " + user.getUsername());
            return ResponseEntity.ok(response);

        } catch (BadCredentialsException e) {
            System.out.println("❌ Authentication failed: Bad credentials");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(Map.of("error", "Invalid username or password"));
        }
    }

}
