package com.apiharrypotter.repositories.role;

import com.apiharrypotter.entities.Rol;
import com.apiharrypotter.enums.ERoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Rol, Long> {
    Optional<Rol> findByRolName(ERoles roleName);
}
