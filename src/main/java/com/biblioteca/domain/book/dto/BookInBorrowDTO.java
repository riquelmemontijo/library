package com.biblioteca.domain.book.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public record BookInBorrowDTO(@NotNull(message = "O id do livro é obrigatório")
                              UUID id,
                              @NotBlank(message = "O título do livro é obrigatório")
                              String title) {
}
