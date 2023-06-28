package com.biblioteca.domain.gender.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;

public record GenderInBookDTO(@NotNull(message = "Genders id is required")
                              UUID id,
                              @NotBlank(message = "Description of gender ir required")
                              String name) {
}
