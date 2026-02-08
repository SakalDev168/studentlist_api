package com.example.studentlist.controllers;

import java.util.Map;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentlist.dto.AuthRequest;
import com.example.studentlist.security.JwtService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/auth")
@Tag(name="Authorization",description="")
public class AuthController {

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthController(JwtService jwtService, AuthenticationManager authenticationManager) {
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody AuthRequest request) {
        try {

            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    request.getUsername(),
                    request.getPassword()
                )
            );

            // Generate JWT 
            String token = jwtService.generateToken(request.getUsername());

            return Map.of("token", token);

        } catch (AuthenticationException ex) {
            //throw new RuntimeException("Invalid username or password");
            return Map.of("error", "Invalid username or password");
        }
    }
}
