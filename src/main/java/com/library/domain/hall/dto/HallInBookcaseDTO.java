package com.library.domain.hall.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;

public record HallInBookcaseDTO(@NotNull(message = "Halls id is required")
                                UUID id,
                                @NotBlank(message = "Halls description is required")
                                String alias) {
}
