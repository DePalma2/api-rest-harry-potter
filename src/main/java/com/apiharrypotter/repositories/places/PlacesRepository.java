package com.apiharrypotter.repositories.places;

import com.apiharrypotter.entities.Places;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlacesRepository extends JpaRepository<Places, Long> {
}
