package com.biblioteca.domain.gender.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public record GenderUpdateDTO(@NotNull(message = "The id is required")
                              UUID id,
                              @NotBlank(message = "The description is required")
                              String name) {
}
