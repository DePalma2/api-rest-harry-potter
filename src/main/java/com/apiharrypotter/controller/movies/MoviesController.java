package com.apiharrypotter.controller.movies;

import com.apiharrypotter.entities.Movies;
import com.apiharrypotter.services.movies.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class MoviesController {

    @Autowired
    private MovieServiceImpl movieService;

    @GetMapping("/movies")
    public List<Movies> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/movies/{id}")
    public Optional<Movies> getMoviesById(@PathVariable(name = "id") Long id){
        return movieService.getById(id);
    }

    @PostMapping("/movies/add")
    public Movies addMovies(@RequestBody Movies movies) {
        movieService.addMovies(movies);
        return movies;
    }

    @DeleteMapping("/movies/{id}/delete")
    public String deleteMoviesById(@PathVariable(name = "id") Movies id) {
        boolean ok = movieService.deleteMovie(id);
        if(ok){
            return "Movie remove with id:  " + id;
        }else{
            return "Error try remove movie with id: " + id;
        }
    }

}
