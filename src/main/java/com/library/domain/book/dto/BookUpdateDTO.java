package com.library.domain.book.dto;

import com.library.domain.author.dto.AuthorInBookDTO;
import com.library.domain.bookcase.dto.BookcaseInBookDTO;
import com.library.domain.genre.dto.GenreInBookDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

public record BookUpdateDTO(@NotNull(message = "The id is required")
                            UUID id,
                            @NotBlank(message = "The title is required")
                            String title,
                            @Valid
                            @NotNull(message = "At least one gender is required")
                            List<GenreInBookDTO> genders,
                            @Valid
                            List<BookcaseInBookDTO> bookcases,
                            @Valid
                            @NotNull(message = "The author is required")
                            List<AuthorInBookDTO> authors) {
}
