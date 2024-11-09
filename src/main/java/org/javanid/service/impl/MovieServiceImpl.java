package org.javanid.service.impl;

import lombok.RequiredArgsConstructor;
import org.javanid.entities.Movie;
import org.javanid.exception.MovieNotFoundException;
import org.javanid.repository.MovieRepository;
import org.javanid.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;


    @Override
    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie validateAndGetMovieById(String imdbId) {
        return movieRepository.findById(imdbId)
                .orElseThrow(() -> new MovieNotFoundException("Movie with id '%s' not found".formatted(imdbId)));
    }

    @Override
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public void deleteMovie(Movie movie) {
        movieRepository.delete(movie);
    }
}
