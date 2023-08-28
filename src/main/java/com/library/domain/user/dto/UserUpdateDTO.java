package com.library.domain.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record UserUpdateDTO(@NotNull(message = "id is required")
                            UUID id,
                            @NotBlank(message = "name is required")
                            String name,
                            @NotBlank(message = "username is required")
                            String username,
                            @NotBlank(message = "email is required")
                            String email,
                            String phoneNumber) {
}
