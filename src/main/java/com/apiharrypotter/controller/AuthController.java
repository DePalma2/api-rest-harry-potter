package com.apiharrypotter.controller;

import com.apiharrypotter.config.jwt.JwtDTO;
import com.apiharrypotter.config.jwt.JwtProvider;
import com.apiharrypotter.dto.LoginUser;
import com.apiharrypotter.dto.NewUser;
import com.apiharrypotter.entities.Rol;
import com.apiharrypotter.entities.User;
import com.apiharrypotter.enums.ERoles;
import com.apiharrypotter.services.role.RoleService;
import com.apiharrypotter.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/newUser")
    public ResponseEntity<?> nuevoUsuario(@Valid @RequestBody NewUser newUser,
                                          BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Campos mal o email invalido");
        }
        if(userService.existsByUsername(newUser.getUsername())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Name Exists");
        }
        if(userService.existsByEmail(newUser.getEmail())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email Exists");
        }

        User us = new User(newUser.getName(), newUser.getUsername(),
                newUser.getEmail(), passwordEncoder.encode(newUser.getPassword()));

        Set<Rol> roles = new HashSet<>();
        roles.add(roleService.getByRolName(ERoles.ROLE_USER).get());
        if(newUser.getRoles().contains("admin"))
            roles.add(roleService.getByRolName(ERoles.ROLE_ADMIN).get());
        us.setRoles(roles);

        userService.save(us);

        return ResponseEntity.status(HttpStatus.CREATED).body("User Created");
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDTO> login(@Valid @RequestBody LoginUser loginUser, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(loginUser.getUsername(),
                                loginUser.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        JwtDTO jwtDto = new JwtDTO(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity<>(jwtDto, HttpStatus.OK);
    }
}
