package com.biblioteca.domain.student.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;

public record StudentInBorrowDTO(@NotNull(message = "Students id is required")
                                 UUID id,
                                 @NotBlank(message = "Students name is required")
                                 String name) {
}
