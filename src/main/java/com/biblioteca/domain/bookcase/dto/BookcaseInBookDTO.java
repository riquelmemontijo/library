package com.biblioteca.domain.bookcase.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public record BookcaseInBookDTO(@NotNull(message = "O id é obrigatório")
                                UUID id,
                                @NotBlank(message = "O nome da estante é obrigatório")
                                String alias) {
}
