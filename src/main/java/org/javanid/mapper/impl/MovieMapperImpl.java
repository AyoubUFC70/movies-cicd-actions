package org.javanid.mapper.impl;

import org.javanid.dtos.CreateMovieRequest;
import org.javanid.dtos.MovieResponse;
import org.javanid.dtos.UpdateMovieRequest;
import org.javanid.entities.Movie;
import org.javanid.mapper.MovieMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class MovieMapperImpl implements MovieMapper {

    @Override
    public Movie toMovie(CreateMovieRequest createMovieRequest) {
        Movie movie = new Movie();
        BeanUtils.copyProperties(createMovieRequest, movie);
        return movie;
    }

    @Override
    public void updateMovieFromUpdateMovieRequest(Movie movie, UpdateMovieRequest updateMovieRequest) {
        if (updateMovieRequest == null) {
            return;
        }
        BeanUtils.copyProperties(updateMovieRequest, movie);
    }

    @Override
    public MovieResponse toMovieResponse(Movie movie) {
        if (movie == null) {
            return null;
        }
        return new MovieResponse(movie.getImdbId(),
                            movie.getTitle(),
                            movie.getYear(),
                            movie.getActors());
    }
}
