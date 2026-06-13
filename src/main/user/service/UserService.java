package com.example.app.user.service;

import com.example.app.user.model.User;
import com.example.app.user.repository.UserRepository;
import lombok.RequiredArgsConstructor; // For clean constructor injection
import org.springframework.stereotype.Service;
import java.util.Optional;

/**
 * Service layer for business logic related to User management.
 */
@Service
@RequiredArgsConstructor // Lombok handles the final field dependency injection
public class UserService {

    private final UserRepository userRepository;






    // Dependency Injection via constructor is now implicit/simplified by @RequiredArgsConstructor
    /**
     * Creates a new user after validating inputs and hashing the password.





     */
    public User registerNewUser(String username, String email, String rawPassword) {

        if (userRepository.findByUsername(username).isPresent()) {
            throw new IllegalArgumentException("Username already taken: " + username);
        }



        // 1. Business logic: Hash the password (Placeholder)
        String hashedPassword = hashPassword(rawPassword); 
        


        // 2. Create Model object using the custom constructor
        User newUser = new User(username, email, rawPassword);
        // Manually overwrite password with hashed value as model constructor doesn't take it
        newUser.setPassword(hashedPassword);
        

        // 3. Persist through Repository
        return userRepository.save(newUser);
    }

    /**
     * Retrieves a user by ID.


     */
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id); 
    }

    /**
     * Updates an existing user's details (e.g., email).




     */
    public Optional<User> updateUser(Long userId, String newEmail, String newPassword) {

        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            return Optional.empty();
        }

        User userToUpdate = optionalUser.get();




        // Update logic and validation placeholder...
        userToUpdate.setEmail(newEmail);
        if (newPassword != null && !newPassword.isEmpty()) {
            String hashedPassword = hashPassword(newPassword); 
            userToUpdate.setPassword(hashedPassword);
        }


        User updatedUser = userRepository.save(userToUpdate);
        return Optional.of(updatedUser);
    }

    /**
     * Deletes a user by ID.


     */
    public boolean deleteUser(Long userId) {

        return userRepository.deleteById(userId);
    }






    private String hashPassword(String rawPassword) {


        // Placeholder for hashing logic (BCrypt should be used).
        return "HASHED_" + Math.abs(rawPassword.hashCode());
    }
}