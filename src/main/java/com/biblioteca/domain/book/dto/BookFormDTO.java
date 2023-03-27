package com.biblioteca.domain.book.dto;

import com.biblioteca.domain.gender.dto.GenderInBookDTO;

import java.util.List;

public record BookFormDTO(String title,
                          List<GenderInBookDTO> genders,
                          String author,
                          Integer units,
                          Integer availableUnits) {
}
