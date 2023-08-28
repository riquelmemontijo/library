package com.library.domain.hall.dto;

import jakarta.validation.constraints.NotBlank;

public record HallFormDTO(@NotBlank(message = "The name is required")
                          String alias) {
}
