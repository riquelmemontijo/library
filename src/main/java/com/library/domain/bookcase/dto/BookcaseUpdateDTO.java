package com.library.domain.bookcase.dto;

import com.library.domain.hall.dto.HallInBookcaseDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;

public record BookcaseUpdateDTO(@NotNull(message = "The id is required")
                                UUID id,
                                @NotBlank(message = "The name is required")
                                String alias,
                                @Valid
                                @NotNull(message = "The hall is required")
                                HallInBookcaseDTO hall) {
}
