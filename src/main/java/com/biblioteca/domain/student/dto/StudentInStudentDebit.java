package com.biblioteca.domain.student.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public record StudentInStudentDebit(@NotNull(message = "O id do estudante é obrigatorio")
                                    UUID id,
                                    @NotBlank(message = "Students name is required")
                                    String name) {
}
