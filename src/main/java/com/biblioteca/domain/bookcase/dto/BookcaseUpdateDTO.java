package com.biblioteca.domain.bookcase.dto;

import com.biblioteca.domain.hall.dto.HallInBookcaseDTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public record BookcaseUpdateDTO(@NotNull(message = "O id da estante é obrigatórip")
                                UUID id,
                                @NotBlank(message = "O nome da estante é obrigatório")
                                String alias,
                                @NotNull(message = "O corredor é orbigatório")
                                HallInBookcaseDTO hall) {
}
