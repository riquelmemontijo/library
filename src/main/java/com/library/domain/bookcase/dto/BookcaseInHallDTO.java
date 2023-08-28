package com.library.domain.bookcase.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;

public record BookcaseInHallDTO(@NotNull(message = "The bookcase id is required")
                                UUID id,
                                @NotBlank(message = "The bookcase id is required")
                                String alias) {
}
