package com.library.domain.student.dto;

import java.time.LocalDate;
import java.util.UUID;

public record StudentInfoDTO(UUID id,
                             String name,
                             LocalDate dateOfBirth,
                             String email,
                             String phoneNumber) {
}
