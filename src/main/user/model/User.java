package com.example.app.user.model;

// Assuming a package structure based on standard Java projects

import java.util.Objects;

public class User {
    private Long id;
    private String username;
    private String email;
    private String password; // Should be hashed in reality

    // Default Constructor
    public User() {}

    // Full Constructor
    public User(Long id, String username, String email, String password) {
        this.id = id;
        this.username = Objects.requireNonNull(username).trim();
        this.email = Objects.requireNonNull(email).trim();
        this.password = Objects.requireNonNull(password).trim();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        // In a real application, hashing would happen here or before setting the value.
        this.password = password; 
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
