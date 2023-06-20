package com.biblioteca.domain.book.dto;

import com.biblioteca.domain.author.dto.AuthorInBookDTO;
import com.biblioteca.domain.bookcase.dto.BookcaseInBookDTO;
import com.biblioteca.domain.gender.dto.GenderInBookDTO;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

public record BookUpdateDTO(@NotNull(message = "The id is required")
                            UUID id,
                            @NotBlank(message = "The title is required")
                            String title,
                            @Valid
                            @NotNull(message = "At least one gender is required")
                            List<GenderInBookDTO> genders,
                            @Valid
                            List<BookcaseInBookDTO> bookcases,
                            @Valid
                            @NotNull(message = "The author is required")
                            List<AuthorInBookDTO> authors) {
}
