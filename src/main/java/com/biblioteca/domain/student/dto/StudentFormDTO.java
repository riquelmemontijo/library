package com.biblioteca.domain.student.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

public record StudentFormDTO(@NotBlank(message = "O nome é obrigatório")
                             String name,
                             @Past(message = "Data de nascimento inválida")
                             @NotNull(message = "A data de nascimento é obrigatória")
                             LocalDate dateOfBirth,
                             @Email(message = "Email em formato inválido")
                             String email,
                             String phoneNumber) {
}
