package com.apiharrypotter.repositories.user;

import com.apiharrypotter.config.jwt.JwtUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<JwtUsers, Long> {

    Optional<JwtUsers> findJwtUsersByUsername(String username);
    Optional<JwtUsers> findJwtUsersByEmail(String email);


}
