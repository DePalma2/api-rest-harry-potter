package com.apiharrypotter.repositories.house;

import com.apiharrypotter.entities.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepository extends JpaRepository<House, Long> {
}
