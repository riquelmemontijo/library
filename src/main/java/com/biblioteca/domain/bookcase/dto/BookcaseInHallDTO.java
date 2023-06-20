package com.biblioteca.domain.bookcase.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public record BookcaseInHallDTO(@NotNull(message = "The bookcase id is required")
                                UUID id,
                                @NotBlank(message = "The bookcase id is required")
                                String alias) {
}
