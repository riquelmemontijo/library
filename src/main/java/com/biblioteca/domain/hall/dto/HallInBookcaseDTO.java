package com.biblioteca.domain.hall.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public record HallInBookcaseDTO(@NotNull(message = "Halls id is required")
                                UUID id,
                                @NotBlank(message = "Halls description is required")
                                String alias) {
}
