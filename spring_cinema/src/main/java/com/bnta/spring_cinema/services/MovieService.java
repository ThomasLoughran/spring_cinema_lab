package com.bnta.spring_cinema.services;

import com.bnta.spring_cinema.models.Movie;
import com.bnta.spring_cinema.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public MovieService(){

    }

    public Movie getMovieById(long id){
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        if (optionalMovie.isPresent()){
            return optionalMovie.get();
        } else {
            return null;
        }
    }

    public void addMovie(Movie movie){
        movieRepository.save(movie);
    }

    public List<Movie> getMovieList(){
        return movieRepository.findAll();
    }

    public String updateMovie(Movie movie, long id){
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        if (optionalMovie.isPresent()){
//            Optional<Movie> optionalUpdatedMovie= Optional.of(movie);
//            movieRepository.findById(id) = optionalUpdatedMovie;
            return "success";
        }
        else {
            return "failed";
        }
    }

    public void deleteMovieById(long id){
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        if (optionalMovie.isPresent()){
            movieRepository.deleteById(id);
        }
    }



}
