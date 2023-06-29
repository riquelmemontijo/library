package com.biblioteca.domain.role.dto;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record RoleUserDTO(@NotNull(message = "Id is required") UUID id) {
}
