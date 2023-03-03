package com.biblioteca.domain.book.dto;

import com.biblioteca.domain.gender.dto.GenderFormDTO;

import java.util.List;

public record BookFormDTO(String title, List<GenderFormDTO> genders, String author, Integer units) {
}
