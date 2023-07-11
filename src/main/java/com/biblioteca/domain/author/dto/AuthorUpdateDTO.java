package com.biblioteca.domain.author.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record AuthorUpdateDTO(@NotNull(message = "Authors id is required")
                              UUID id,
                              @NotBlank(message = "Authors name is required")
                              String name) {
}
