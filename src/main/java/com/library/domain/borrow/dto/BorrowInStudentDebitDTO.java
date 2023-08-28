package com.library.domain.borrow.dto;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

public record BorrowInStudentDebitDTO(@NotNull(message = "The borrow id is required")
                                      UUID id) {
}
