package com.biblioteca.domain.book.dto;

import com.biblioteca.domain.gender.dto.GenderFormDTO;

import java.util.List;
import java.util.UUID;

public record BookInfoDTO(UUID id, String title, List<GenderFormDTO> genders, String author, Integer units, Integer availableUnits) {
}
