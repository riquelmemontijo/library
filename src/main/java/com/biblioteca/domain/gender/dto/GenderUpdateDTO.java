package com.biblioteca.domain.gender.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;

public record GenderUpdateDTO(@NotNull(message = "The id is required")
                              UUID id,
                              @NotBlank(message = "The description is required")
                              String name) {
}
