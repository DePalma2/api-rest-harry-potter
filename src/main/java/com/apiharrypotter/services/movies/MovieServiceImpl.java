package com.apiharrypotter.services.movies;

import com.apiharrypotter.entities.Movies;
import com.apiharrypotter.repositories.movies.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movies> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Optional<Movies> getById(Long id) {
        return movieRepository.findById(id);
    }

    @Override
    public Movies addMovies(Movies movies) {
        movieRepository.save(movies);
        return movies;
    }

    @Override
    public Movies updateMovies(Long id, Movies movies) {
        if(movieRepository.findById(id).isPresent()) {
            Movies existMovies= movieRepository.findById(id).get();
            existMovies.setTitle(movies.getTitle());
            movieRepository.save(existMovies);
            return existMovies;
        }else {
            return null;
        }
    }

    @Override
    public boolean deleteMovie(Movies movies) {
        try {
            movieRepository.delete(movies);
            return true;
        }catch (Exception e) {
            return false;
        }
    }
}
