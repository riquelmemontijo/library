package com.biblioteca.domain.bookcase.dto;

import com.biblioteca.domain.book.dto.BookInBookcaseDTO;
import com.biblioteca.domain.hall.dto.HallInBookcaseDTO;

import java.util.List;
import java.util.UUID;

public record BookcaseInfoDTO(UUID id, String alias, List<BookInBookcaseDTO> books, HallInBookcaseDTO hall) {
}
