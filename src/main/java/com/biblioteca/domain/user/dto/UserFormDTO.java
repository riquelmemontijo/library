package com.biblioteca.domain.user.dto;

import com.biblioteca.domain.role.dto.RoleUserDTO;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record UserFormDTO(@NotBlank(message = "name is required")
                          String name,
                          @NotBlank(message = "username is required")
                          String username,
                          @NotBlank(message = "password is required")
                          String password,
                          @NotBlank(message = "email is required")
                          String email,
                          String phoneNumber,
                          List<RoleUserDTO> roles) {
}