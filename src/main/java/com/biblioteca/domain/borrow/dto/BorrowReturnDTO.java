package com.biblioteca.domain.borrow.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record BorrowReturnDTO (@NotNull(message = "The id is required")
                               UUID id,
                               @NotNull(message = "The return date is required")
                               @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
                               LocalDate returnDate){
}
