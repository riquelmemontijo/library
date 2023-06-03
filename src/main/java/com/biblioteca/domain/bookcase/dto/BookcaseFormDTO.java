package com.biblioteca.domain.bookcase.dto;

import com.biblioteca.domain.hall.dto.HallInBookcaseDTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record BookcaseFormDTO(@NotBlank(message = "O nome da estante é obrigatória")
                              String alias,
                              @NotNull(message = "O corredor é orbigatório")
                              HallInBookcaseDTO hall) {
}
