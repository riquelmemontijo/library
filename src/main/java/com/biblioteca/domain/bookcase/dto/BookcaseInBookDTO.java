package com.biblioteca.domain.bookcase.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public record BookcaseInBookDTO(@NotNull(message = "The bookcase id is required")
                                UUID id,
                                @NotBlank(message = "The bookcase name is required")
                                String alias) {
}
