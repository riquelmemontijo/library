package com.library.domain.author.dto;

import jakarta.validation.constraints.NotBlank;

public record AuthorFormDTO(@NotBlank(message = "Author's name is required")
                            String name) {
}
