package com.apiharrypotter.controller.movies;

import com.apiharrypotter.entities.Movies;
import com.apiharrypotter.services.movies.MovieServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@Api(tags = "Movies", value = "Movie", description = "Information about the movies")
public class MoviesController {

    @Autowired
    private MovieServiceImpl movieService;

    @GetMapping("/movies")
    @ApiOperation(value = "List all movies")
    @ResponseStatus(HttpStatus.OK)
    public List<Movies> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/movies/{id}")
    @ApiOperation(value = "Returns a movie with a specific id", notes = "Movie must exist")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Movies> getMoviesById(@PathVariable(name = "id") Long id){
        return movieService.getById(id);
    }

    @PostMapping("/add/movies")
    @ApiOperation(value = "Create a movie")
    @ResponseStatus(HttpStatus.CREATED)
    public Movies addMovies(@RequestBody Movies movies) {
        movieService.addMovies(movies);
        return movies;
    }

    @DeleteMapping("/delete/movies/{id}")
    @ApiOperation(value = "Delete a chapter", notes = "Movie must exist")
    @ResponseStatus(HttpStatus.OK)
    public String deleteMoviesById(@PathVariable(name = "id") Movies id) {
        boolean ok = movieService.deleteMovie(id);
        if(ok){
            return "Movie remove with id:  " + id;
        }else{
            return "Error try remove movie with id: " + id;
        }
    }

}
