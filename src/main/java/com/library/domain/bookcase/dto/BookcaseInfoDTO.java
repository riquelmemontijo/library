package com.library.domain.bookcase.dto;

import com.library.domain.book.dto.BookInBookcaseDTO;
import com.library.domain.hall.dto.HallInBookcaseDTO;

import java.util.List;
import java.util.UUID;

public record BookcaseInfoDTO(UUID id,
                              String alias,
                              List<BookInBookcaseDTO> books,
                              HallInBookcaseDTO hall) {
}
