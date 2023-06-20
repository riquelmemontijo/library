package com.biblioteca.domain.bookcase.dto;

import com.biblioteca.domain.hall.dto.HallInBookcaseDTO;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public record BookcaseUpdateDTO(@NotNull(message = "The id is required")
                                UUID id,
                                @NotBlank(message = "The name is required")
                                String alias,
                                @Valid
                                @NotNull(message = "The hall is required")
                                HallInBookcaseDTO hall) {
}
