package com.biblioteca.domain.book.dto;

import com.biblioteca.domain.bookcase.dto.BookcaseInBookDTO;
import com.biblioteca.domain.gender.dto.GenderFormDTO;

import java.util.List;
import java.util.UUID;

public record BookInfoDTO(UUID id,
                          String title,
                          List<GenderFormDTO> genders,
                          List<BookcaseInBookDTO> bookcases,
                          String author,
                          Integer units,
                          Integer availableUnits) {
}
