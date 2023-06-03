package com.biblioteca.domain.hall.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public record HallInBookcaseDTO(@NotNull(message = "O id do corredor é obrigatório")
                                UUID id,
                                @NotBlank(message = "A descrição do corredor é obrigatória")
                                String alias) {
}
