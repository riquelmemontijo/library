package com.library.domain.bookcase.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;

public record BookcaseInBookDTO(@NotNull(message = "The bookcase id is required")
                                UUID id,
                                @NotBlank(message = "The bookcase name is required")
                                String alias) {
}
