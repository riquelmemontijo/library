package com.library.domain.book.dto;

import com.library.domain.author.dto.AuthorInBookDTO;
import com.library.domain.bookcase.dto.BookcaseInBookDTO;
import com.library.domain.genre.dto.GenreFormDTO;

import java.util.List;
import java.util.UUID;

public record BookInfoDTO(UUID id,
                          String title,
                          List<GenreFormDTO> genders,
                          List<BookcaseInBookDTO> bookcases,
                          List<AuthorInBookDTO> authors,
                          Integer units,
                          Integer availableUnits) {
}
