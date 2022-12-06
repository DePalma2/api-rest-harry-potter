package com.apiharrypotter.services.user;

import com.apiharrypotter.entities.User;
import com.apiharrypotter.repositories.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> getByUsername(String username){
        return userRepository.findByUsername(username);
    }
    public Boolean existsByUsername(String username){
        return userRepository.existsByUsername(username);
    }
    public Boolean existsByEmail(String email){
        return userRepository.existsByEmail(email);
    }
    public void save(User username){
        userRepository.save(username);
    }

}
