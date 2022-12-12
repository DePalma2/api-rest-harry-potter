package com.apiharrypotter.services.user;

import com.apiharrypotter.config.jwt.JwtUsers;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class jwtUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        JwtUsers user = userService.getUserByUsername(email);
        return new User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, user.getAuthorities());
    }

}
