package com.biblioteca.domain.gender.dto;

import com.biblioteca.domain.gender.Gender;

import java.util.UUID;

public record GenderInfoDTO(UUID id, String name) {
    public GenderInfoDTO(Gender gender){
        this(gender.getId(), gender.getName());
    }
}
