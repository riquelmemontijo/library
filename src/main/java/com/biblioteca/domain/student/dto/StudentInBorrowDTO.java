package com.biblioteca.domain.student.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public record StudentInBorrowDTO(@NotNull(message = "Students id is required")
                                 UUID id,
                                 @NotBlank(message = "Students name is required")
                                 String name) {
}
