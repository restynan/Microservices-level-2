package io.javabrains.movieinfoservice.controller;

import io.javabrains.movieinfoservice.models.Movie;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class movieController {

    @RequestMapping("/{movieId}")
    public Movie getMovies(@PathVariable("movieId") String movieId){
        return new Movie(movieId, "tantanic");
    }
}
