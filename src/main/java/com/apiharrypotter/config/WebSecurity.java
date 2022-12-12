package com.apiharrypotter.config;

import com.apiharrypotter.config.jwt.jwtAuthenticationFilter;
import com.apiharrypotter.services.user.jwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

@Configuration
public class WebSecurity {

    @Autowired
    private AuthenticationManager authenticationManager;
    private final AuthSuccessHandler authSuccessHandler;
    private final com.apiharrypotter.services.user.jwtUserDetailsService jwtUserDetailsService;
    private final String secret;

    public WebSecurity(AuthSuccessHandler authSuccessHandler, com.apiharrypotter.services.user.jwtUserDetailsService jwtUserDetailsService,@Value("${jwt.secret}") String secret) {
        this.authSuccessHandler = authSuccessHandler;
        this.jwtUserDetailsService = jwtUserDetailsService;
        this.secret = secret;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http ) throws Exception {
        http.cors().and().csrf().disable().authorizeHttpRequests((auth) -> {
            try {
                auth
                        .antMatchers("/user").hasRole("USER")
                        .antMatchers("/admin").hasRole("ADMIN")
                        .anyRequest()
                        .permitAll()
                        .and()
                        .sessionManagement()
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                        .and().addFilter(authenticationFilter())
                        .addFilter(new jwtAuthenticationFilter(authenticationManager, jwtUserDetailsService, secret))
                        .exceptionHandling()
                        .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public AuthenticationFilter authenticationFilter() throws Exception {
        AuthenticationFilter filter = new AuthenticationFilter();
        filter.setAuthenticationSuccessHandler(authSuccessHandler);
        filter.setAuthenticationManager(authenticationManager);
        return filter;
    }

}
