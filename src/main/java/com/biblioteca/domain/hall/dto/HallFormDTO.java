package com.biblioteca.domain.hall.dto;

import javax.validation.constraints.NotBlank;

public record HallFormDTO(@NotBlank(message = "O nome do corredor é obrigatório")
                          String alias) {
}
