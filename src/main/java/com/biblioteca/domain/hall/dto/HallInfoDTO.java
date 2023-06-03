package com.biblioteca.domain.hall.dto;

import com.biblioteca.domain.bookcase.dto.BookcaseInHallDTO;

import java.util.List;
import java.util.UUID;

public record HallInfoDTO(UUID id, String alias, List<BookcaseInHallDTO> bookcases) {
}
