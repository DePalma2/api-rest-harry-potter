package com.apiharrypotter.services.user;

import com.apiharrypotter.config.jwt.JwtUsers;
import com.apiharrypotter.repositories.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public JwtUsers save(JwtUsers users) {
        return userRepository.save(users);
    }

    public Optional<JwtUsers> findUserByEmail(String email) {
        return userRepository.findJwtUsersByEmail(email);
    }

    public JwtUsers getUserByEmail(String email) {
        return userRepository
                .findJwtUsersByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("User Not found by email " + email));
    }

    public JwtUsers getUserByUsername(String username) {
        return userRepository
                .findJwtUsersByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("User Not found by username " + username));
    }

}
