package com.biblioteca.domain.gender.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public record GenderUpdateDTO(@NotNull(message = "O id é obrigatório")
                              UUID id,
                              @NotBlank(message = "A descrição é obrigatória")
                              String name) {
}
