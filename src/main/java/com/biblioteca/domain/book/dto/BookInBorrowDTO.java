package com.biblioteca.domain.book.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;

public record BookInBorrowDTO(@NotNull(message = "Books id is required")
                              UUID id,
                              @NotBlank(message = "Books title is required")
                              String title) {
}
