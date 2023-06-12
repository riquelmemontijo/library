package com.biblioteca.domain.author.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public record AuthorInBookDTO(@NotNull(message = "Author id is required")
                              UUID id,
                              @NotBlank(message = "Author name is required")
                              String name) {
}
