package com.biblioteca.domain.gender.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public record GenderInBookDTO(@NotNull(message = "O id do gênero é obrigatório")
                              UUID id,
                              @NotBlank(message = "A descrição do gênero é obrigatória")
                              String name) {
}
