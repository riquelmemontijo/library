package com.library.domain.student.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.util.UUID;

public record StudentUpdateDTO(@NotNull(message = "The id is required")
                               UUID id,
                               @NotBlank(message = "The name is required")
                               String name,
                               @Past(message = "That date of birth is invalid")
                               @NotNull(message = "Date of birth is required")
                               LocalDate dateOfBirth,
                               @NotBlank(message = "The email is required")
                               @Email(message = "That format of email is invalid")
                               String email,
                               @Pattern(message = "Ivalid format of phone number",
                                       regexp = "\\(\\d{2}\\)\\s?\\d{4,5}-\\d{4}")
                               String phoneNumber) {
}
