package com.library.domain.bookcase.dto;

import com.library.domain.hall.dto.HallInBookcaseDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BookcaseFormDTO(@NotBlank(message = "Bookcases name is required")
                              String alias,
                              @NotNull(message = "The hall is required")
                              HallInBookcaseDTO hall) {
}
