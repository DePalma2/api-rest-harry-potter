package com.apiharrypotter.services.movies;

import com.apiharrypotter.entities.Movies;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    public List<Movies> getAllMovies();
    public Optional<Movies> getById(Long id);
    public Movies addMovies(Movies movies);
    public Movies updateMovies(Long id,Movies movies);
    public boolean deleteMovie(Movies movies);

}
