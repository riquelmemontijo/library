package com.library.domain.book.dto;

import com.library.domain.author.dto.AuthorInBookDTO;
import com.library.domain.bookcase.dto.BookcaseInBookDTO;
import com.library.domain.genre.dto.GenreInBookDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.util.List;

public record BookFormDTO(@NotBlank(message = "The title is required")
                          String title,
                          @Valid
                          @NotNull(message = "At least one genre is required")
                          List<GenreInBookDTO> genders,
                          @Valid
                          List<BookcaseInBookDTO> bookcases,
                          @Valid
                          @NotNull(message = "The author is required")
                          List<AuthorInBookDTO> authors,
                          @PositiveOrZero(message = "The quantity of units should be bigger or equal to zero")
                          Integer units,
                          @PositiveOrZero(message = "The quantity of available units should be bigger or equal to zero")
                          Integer availableUnits) {
}
