package main.auth.service;

import main.user.model.User;
import main.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;

    public String authenticate(String username, String password) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(username, password)
        );
        return "Autenticado correctamente";
    }

    public User register(User user) {
        return userRepository.save(user);
    }
}