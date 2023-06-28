package com.biblioteca.domain.student.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;

public record StudentInStudentDebit(@NotNull(message = "O id do estudante é obrigatorio")
                                    UUID id,
                                    @NotBlank(message = "Students name is required")
                                    String name) {
}
