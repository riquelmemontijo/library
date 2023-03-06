package com.biblioteca.domain.gender.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record GenderFormDTO (@NotBlank @NotNull @Length(min = 0, max = 20) String name){
}
