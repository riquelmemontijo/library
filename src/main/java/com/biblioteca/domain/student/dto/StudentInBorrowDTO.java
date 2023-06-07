package com.biblioteca.domain.student.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public record StudentInBorrowDTO(@NotNull(message = "O id do estudante é obrigatorio")
                                 UUID id,
                                 @NotBlank(message = "O nome do estudante é obrigatório")
                                 String name,
                                 @NotBlank(message = "O email é obrigatório")
                                 String email,
                                 @NotBlank(message = "O telefone é obrigatório")
                                 String phoneNumber) {
}
