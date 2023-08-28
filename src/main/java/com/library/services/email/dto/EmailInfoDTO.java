package com.library.services.email.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record EmailInfoDTO(UUID id,
                           String subject,
                           String from,
                           String to,
                           String status,
                           LocalDateTime sendDate) {
}
