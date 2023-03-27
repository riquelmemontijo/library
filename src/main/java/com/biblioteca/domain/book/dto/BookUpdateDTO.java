package com.biblioteca.domain.book.dto;

import com.biblioteca.domain.gender.dto.GenderFormDTO;
import com.biblioteca.domain.gender.dto.GenderInBookDTO;

import java.util.List;
import java.util.UUID;

public record BookUpdateDTO(UUID id, String title, List<GenderInBookDTO> genders, String author) {
}
