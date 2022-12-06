package com.apiharrypotter.dto;

import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

public class NewUser {

    @NotBlank
    private String name;
    @NotBlank
    private String username;
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    private Set<String> roles = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        this.password = password;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}
