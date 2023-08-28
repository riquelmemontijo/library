package com.library.domain.hall.dto;

import com.library.domain.bookcase.dto.BookcaseInHallDTO;

import java.util.List;
import java.util.UUID;

public record HallInfoDTO(UUID id, String alias, List<BookcaseInHallDTO> bookcases) {
}
