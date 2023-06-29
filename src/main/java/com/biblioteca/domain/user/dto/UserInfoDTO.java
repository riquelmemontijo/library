package com.biblioteca.domain.user.dto;

import com.biblioteca.domain.user.enums.StatusUser;

import java.time.LocalDateTime;
import java.util.UUID;

public record UserInfoDTO(UUID id,
                          String name,
                          String username,
                          String email,
                          String phoneNumber,
                          StatusUser status,
                          LocalDateTime createdAt,
                          LocalDateTime updatedAt) {
}