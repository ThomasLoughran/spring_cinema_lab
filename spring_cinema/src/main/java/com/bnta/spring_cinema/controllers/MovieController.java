package com.bnta.spring_cinema.controllers;

import com.bnta.spring_cinema.models.Movie;
import com.bnta.spring_cinema.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping(value = "/{id}")
    ResponseEntity<Movie> returnMovie(@PathVariable long id){
        Movie movie = movieService.getMovieById(id);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @GetMapping
    ResponseEntity<List<Movie>> returnAllMovies(){
        List<Movie> movies = movieService.getMovieList();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity<>("Movie added", HttpStatus.CREATED);
    }




}
