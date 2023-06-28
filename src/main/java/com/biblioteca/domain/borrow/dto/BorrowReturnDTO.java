package com.biblioteca.domain.borrow.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

public record BorrowReturnDTO (@NotNull(message = "The id is required")
                               UUID id,
                               @NotNull(message = "The return date is required")
                               @JsonFormat(pattern = "yyyy-MM-dd")
                               LocalDate returnDate){
}
