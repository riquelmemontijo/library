package com.library.domain.genre.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;

public record GenreInBookDTO(@NotNull(message = "Genders id is required")
                              UUID id,
                             @NotBlank(message = "Description of gender ir required")
                              String name) {
}
