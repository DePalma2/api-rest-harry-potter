package com.apiharrypotter.repositories.movies;

import com.apiharrypotter.entities.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movies, Long> {
}
