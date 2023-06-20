package com.biblioteca.domain.hall.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public record HallUpdateDTO(@NotNull(message = "The id is required")
                            UUID id,
                            @NotBlank(message = "The name is required")
                            String alias) {
}
