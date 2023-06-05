package com.biblioteca.domain.bookcase.dto;

import com.biblioteca.domain.hall.dto.HallInBookcaseDTO;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public record BookcaseUpdateDTO(@NotNull(message = "O id da estante é obrigatórip")
                                UUID id,
                                @NotBlank(message = "O nome da estante é obrigatório")
                                String alias,
                                @Valid
                                @NotNull(message = "O corredor é obrigatório")
                                HallInBookcaseDTO hall) {
}
