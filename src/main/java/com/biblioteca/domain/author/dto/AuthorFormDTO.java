package com.biblioteca.domain.author.dto;

import javax.validation.constraints.NotBlank;

public record AuthorFormDTO(@NotBlank(message = "Author name is required")
                            String name) {
}
