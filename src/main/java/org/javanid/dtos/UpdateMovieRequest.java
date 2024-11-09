package org.javanid.dtos;

public record UpdateMovieRequest(
        String title,
        Integer year,
        String actors) {
}
