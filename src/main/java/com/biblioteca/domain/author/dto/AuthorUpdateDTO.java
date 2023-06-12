package com.biblioteca.domain.author.dto;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public record AuthorUpdateDTO(@NotBlank(message = "Author id is required")
                              UUID id,
                              @NotBlank(message = "Author name is required")
                              String name) {
}
