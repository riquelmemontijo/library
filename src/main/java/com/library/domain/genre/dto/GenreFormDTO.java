package com.library.domain.genre.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;

public record GenreFormDTO(@NotBlank(message = "The description is required")
                             @Length(min = 0, max = 20, message = "The description must be less than twenty characters")
                             String name){
}
