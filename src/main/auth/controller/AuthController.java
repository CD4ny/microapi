package main.auth.controller;

import main.auth.dto.LoginRequest;
import main.auth.dto.RegisterRequest;
import main.user.model.User;
import main.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        String result = authService.authenticate(request.getUsername(), request.getPassword());
        return ResponseEntity.ok(result);
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterRequest request) {
        User user = authService.register(User.builder()
            .username(request.getUsername())
            .password(request.getPassword())
            .enabled(true)
            .build());
        return ResponseEntity.ok(user);
    }
}