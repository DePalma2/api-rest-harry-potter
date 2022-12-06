package com.apiharrypotter.utils;

import com.apiharrypotter.entities.Rol;
import com.apiharrypotter.enums.ERoles;
import com.apiharrypotter.services.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CreateRoles implements CommandLineRunner {
    @Autowired
    RoleService roleService;

    @Override
    public void run(String... args) throws Exception {
        Rol rolAdmin = new Rol(ERoles.ROLE_ADMIN);
        Rol rolUser = new Rol(ERoles.ROLE_USER);
        roleService.save(rolAdmin);
        roleService.save(rolUser);
    }
}
