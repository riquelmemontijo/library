package com.library.domain.hall.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;

public record HallUpdateDTO(@NotNull(message = "The id is required")
                            UUID id,
                            @NotBlank(message = "The name is required")
                            String alias) {
}
