package com.biblioteca.domain.gender.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

public record GenderFormDTO (@NotBlank(message = "A descrição do gênero é obrigatória")
                             @Length(min = 0, max = 20, message = "A descrição deve conter menos de 20 caracteres")
                             String name){
}
