package com.biblioteca.domain.author.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public record AuthorInBookDTO(@NotNull(message = "Authors id is required")
                              UUID id,
                              @NotBlank(message = "Authors name is required")
                              String name) {
}
