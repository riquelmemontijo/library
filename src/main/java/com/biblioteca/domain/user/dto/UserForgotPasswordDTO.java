package com.biblioteca.domain.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserForgotPasswordDTO(@Email(message = "Incorrect format of email.")
                                    @NotBlank(message = "Email is required")
                                    String email) {
}
