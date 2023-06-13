package com.biblioteca.domain.borrow.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

public record BorrowReturnDTO (@NotNull(message = "O id é obrigatório")
                               UUID id,
                               @NotNull(message = "A data da devolução é obrigatória")
                               @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
                               LocalDateTime returnDate){
}
