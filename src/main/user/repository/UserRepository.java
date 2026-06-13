package com.example.app.user.repository;

import com.example.app.user.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Repository layer for User operations. Simulates interaction with a database.
 */
@Repository
public class UserRepository {

    // In-memory storage simulating a database table (ID -> User object)
    private final Map<Long, User> userStore = new ConcurrentHashMap<>();
    private long nextId = 1L;

    /**
     * Finds a user by their ID.
     * @param id The ID of the user.
     * @return Optional containing the User if found.
     */
    public Optional<User> findById(Long id) {
        System.out.println("Repository: Fetching user with ID " + id);
        return Optional.ofNullable(userStore.get(id));
    }

    /**
     * Finds a user by their unique username.
     * @param username The username to search for.
     * @return Optional containing the User if found.
     */
    public Optional<User> findByUsername(String username) {
        System.out.println("Repository: Searching for user with username " + username);
        return userStore.values().stream()
                .filter(user -> user.getUsername().equalsIgnoreCase(username))
                .findFirst();
    }

    /**
     * Saves a new or updated user to the store.
     * @param user The User object to save. Must have an ID set if updating.
     * @return The saved User object with assigned/updated ID.
     */
    public User save(User user) {
        if (user.getId() == null || !userStore.containsKey(user.getId())) {
            // New user
            long newId = nextId++;
            user.setId(newId);
            userStore.put(newId, user);
            System.out.println("Repository: Saved new user with ID " + newId);
        } else {
            // Update existing user (assuming the calling service validates ownership/permissions)
            userStore.put(user.getId(), user);
            System.out.println("Repository: Updated user with ID " + user.getId());
        }
        return user;
    }

    /**
     * Deletes a user by their ID.
     * @param id The ID of the user to delete.
     * @return true if deleted, false otherwise.
     */
    public boolean deleteById(Long id) {
        if (userStore.remove(id) != null) {
            System.out.println("Repository: Deleted user with ID " + id);
            return true;
        }
        System.out.println("Repository: User with ID " + id + " not found for deletion.");
        return false;
    }

    /**
     * Gets all users (Cautionary method, generally avoided in production).
     */
    public List<User> findAll() {
        return userStore.values().stream().toList();
    }
}