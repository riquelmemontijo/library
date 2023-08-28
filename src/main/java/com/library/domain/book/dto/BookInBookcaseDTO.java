package com.library.domain.book.dto;

import com.library.domain.genre.dto.GenreFormDTO;

import java.util.List;
import java.util.UUID;

public record BookInBookcaseDTO(UUID id,
                                String title,
                                List<GenreFormDTO> genders,
                                String author,
                                Integer units,
                                Integer availableUnits) {
}
