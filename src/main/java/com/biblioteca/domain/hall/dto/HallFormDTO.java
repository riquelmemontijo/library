package com.biblioteca.domain.hall.dto;

import javax.validation.constraints.NotBlank;

public record HallFormDTO(@NotBlank(message = "The name is required")
                          String alias) {
}
