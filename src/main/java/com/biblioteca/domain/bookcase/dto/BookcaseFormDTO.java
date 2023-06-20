package com.biblioteca.domain.bookcase.dto;

import com.biblioteca.domain.hall.dto.HallInBookcaseDTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record BookcaseFormDTO(@NotBlank(message = "Bookcases name is required")
                              String alias,
                              @NotNull(message = "The hall is required")
                              HallInBookcaseDTO hall) {
}
