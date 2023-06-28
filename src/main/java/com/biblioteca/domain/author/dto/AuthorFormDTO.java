package com.biblioteca.domain.author.dto;

import jakarta.validation.constraints.NotBlank;

public record AuthorFormDTO(@NotBlank(message = "Author name is required")
                            String name) {
}
