package org.javanid.service;

import org.javanid.entities.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> getMovies();
    Movie validateAndGetMovieById(String imdbId);
    Movie saveMovie(Movie movie);
    void deleteMovie(Movie movie);
}
