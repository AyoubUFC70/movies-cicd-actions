package org.javanid.dtos;

public record MovieResponse(
        String imdbId,
        String title,
        Integer year,
        String actors) {
}
