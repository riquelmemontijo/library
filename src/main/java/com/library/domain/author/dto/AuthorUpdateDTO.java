package com.library.domain.author.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record AuthorUpdateDTO(@NotNull(message = "Author's id is required")
                              UUID id,
                              @NotBlank(message = "Author's name is required")
                              String name) {
}
