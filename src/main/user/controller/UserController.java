package com.example.app.user.controller;

import com.example.app.user.model.User;
import com.example.app.user.service.UserService;
import lombok.RequiredArgsConstructor; // Lombok for constructor injection
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * REST Controller for User endpoints.
 */
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor // Lombok generates constructor injecting UserService
public class UserController {

    private final UserService userService; 

    // --- DTOs (Data Transfer Objects) using Lombok ---

    /**
     * Used for POST /register requests
     */
    @lombok.Data // Generates getters, setters, toString(), etc.
    public static class RegistrationRequest {
        private String username; 
        private String email;
        private String password;
    }

    /**
     * Used for PUT /update requests
     */
    @lombok.Data // Generates getters, setters, toString(), etc.
    public static class UpdateRequest {
        private String email; // Can be null if only updating email
        private String password; 
    }

    // --- Endpoints ---

    /**
     * POST /api/v1/users/register
     * Registers a new user.
     */
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody RegistrationRequest request) {
        try {
            // Delegate the core business logic to the service layer
            User newUser = userService.registerNewUser(request.getUsername(), request.getEmail(), request.getPassword());
            return new ResponseEntity<>(newUser, HttpStatus.CREATED); // 201 Created
        } catch (IllegalArgumentException e) {
            // Handle validation/business exceptions gracefully
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST); // 400 Bad Request
        }
    }

    /**
     * GET /api/v1/users/{id}
     * Retrieves a user by their ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        Optional<User> optionalUser = userService.getUserById(id);
        return optionalUser.map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND)); // 404
    }

    /**
     * PUT /api/v1/users/{id}/update
     * Updates user information (e.g., email or password).
     */
    @PutMapping("/{id}/update")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UpdateRequest request) {
        Optional<User> optionalUpdatedUser = userService.updateUser(id, request.getEmail(), request.getPassword());
        return optionalUpdatedUser.map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND)); // 404
    }

    /**
     * DELETE /api/v1/users/{id}
     * Deletes a user by ID.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        boolean success = userService.deleteUser(id);
        return success ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND); 
    }
}