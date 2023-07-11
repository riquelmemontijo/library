package com.biblioteca.domain.user.dto;

import jakarta.validation.constraints.NotBlank;

public record UserForgotPasswordUpdateDTO(@NotBlank(message = "Password is required.")
                                          String password) {
}
