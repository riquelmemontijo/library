package com.library.domain.user.dto;

import java.util.UUID;

public record UserUpdatePasswordDTO(UUID id, String password) {
}
