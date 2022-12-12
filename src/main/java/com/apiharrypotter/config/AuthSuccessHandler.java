package com.apiharrypotter.config;

import com.apiharrypotter.services.user.UserService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Component
@Slf4j
public class AuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final int expTime;
    private String secret;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final UserService userService;

    public AuthSuccessHandler(int expTime, String secret, UserService userService) {
        this.expTime = expTime;
        this.secret = secret;
        this.userService = userService;
    }

    @Override
    public void onAuthenticationSuccess
            (HttpServletRequest request
            , HttpServletResponse response
            , Authentication authentication)
            throws IOException, ServletException {
        UserDetails main = (UserDetails) authentication.getPrincipal();
        String token = JWT.create()
                .withSubject(userService
                        .getUserByUsername(main.getUsername()).getEmail())
                .withExpiresAt(Instant
                        .ofEpochMilli(ZonedDateTime
                                .now(ZoneId.systemDefault())
                                .toInstant()
                                .toEpochMilli() + expTime))
                .sign(Algorithm.HMAC256(secret));
        response.addHeader("Authorization", "Bearer" + token);
        response.addHeader("Content-Type", "application/json");
        response.getWriter().write("{\"token\" : \"" + token + "\"}");
    }

}
