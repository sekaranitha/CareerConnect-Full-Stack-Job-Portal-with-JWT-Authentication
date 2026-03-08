package com.careerconnect.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.careerconnect.model.User;
import com.careerconnect.security.JwtUtil;
import com.careerconnect.service.AuthService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    private final AuthService service;
    private final JwtUtil jwtUtil;

    public AuthController(AuthService service, JwtUtil jwtUtil) {
        this.service = service;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {

        User validUser = service.validateUser(user.getEmail(), user.getPassword());

        if (validUser != null) {
            String token = jwtUtil.generateToken(validUser.getEmail());

            return ResponseEntity.ok(
                    Map.of(
                            "token", token,
                            "role", validUser.getRole()
                    )
            );
        }

        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body("Invalid Credentials");
    }
}