package org.javanid.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateMovieRequest(
        @NotBlank String imdbId,
        @NotBlank String title,
        @NotNull Integer year,
        @NotBlank String actors) {
}
