package org.javanid.mapper;

import org.javanid.dtos.CreateMovieRequest;
import org.javanid.dtos.MovieResponse;
import org.javanid.dtos.UpdateMovieRequest;
import org.javanid.entities.Movie;

public interface MovieMapper {

    Movie toMovie(CreateMovieRequest createMovieRequest);
    void updateMovieFromUpdateMovieRequest(Movie movie, UpdateMovieRequest updateMovieRequest);
    MovieResponse toMovieResponse(Movie movie);
}
