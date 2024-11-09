package org.javanid.web;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.javanid.dtos.CreateMovieRequest;
import org.javanid.dtos.MovieResponse;
import org.javanid.dtos.UpdateMovieRequest;
import org.javanid.entities.Movie;
import org.javanid.mapper.MovieMapper;
import org.javanid.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;
    private final MovieMapper movieMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MovieResponse createMovie(@Valid @RequestBody CreateMovieRequest createMovieRequest) {
         Movie movie = movieService.saveMovie(movieMapper.toMovie(createMovieRequest));
         return movieMapper.toMovieResponse(movie);
    }

    @GetMapping
    public List<MovieResponse> getMovies() {
        return movieService.getMovies()
                .stream()
                .map(movieMapper::toMovieResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/{imdbId}")
    public MovieResponse getMovie(@PathVariable String imdbId) {
        Movie movie = movieService.validateAndGetMovieById(imdbId);
        return movieMapper.toMovieResponse(movie);
    }

    @PatchMapping("/{imdbId}")
    public MovieResponse updateMovie(@PathVariable String imdbId, @Valid @RequestBody UpdateMovieRequest updateMovieRequest) {
        Movie movie = movieService.validateAndGetMovieById(imdbId);
        movieMapper.updateMovieFromUpdateMovieRequest(movie, updateMovieRequest);
        return movieMapper.toMovieResponse(movieService.saveMovie(movie));
    }

    @DeleteMapping("/{imdbId}")
    public void deleteMovie(@PathVariable String imdbId) {
        Movie movie = movieService.validateAndGetMovieById(imdbId);
        movieService.deleteMovie(movie);
    }
}

