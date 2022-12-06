package com.apiharrypotter.services.role;

import com.apiharrypotter.entities.Rol;
import com.apiharrypotter.enums.ERoles;
import com.apiharrypotter.repositories.role.RoleRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class RoleService {

    private RoleRepository roleRepository;

    public Optional<Rol> getByRolName(ERoles roleName){
        return  roleRepository.findByRolName(roleName);
    }
    public void save(Rol rol){
        roleRepository.save(rol);
    }

}
