package com.biblioteca.domain.gender.dto;

import lombok.Builder;

import java.util.UUID;

public record GenderInfoDTO(UUID id, String name) {
}
