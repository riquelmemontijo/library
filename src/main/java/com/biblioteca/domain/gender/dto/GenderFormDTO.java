package com.biblioteca.domain.gender.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

public record GenderFormDTO (@NotBlank(message = "The description is required")
                             @Length(min = 0, max = 20, message = "The description must be less than twenty characters")
                             String name){
}
